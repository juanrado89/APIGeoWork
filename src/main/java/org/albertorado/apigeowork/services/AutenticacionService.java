package org.albertorado.apigeowork.services;

import io.jsonwebtoken.*;
import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.albertorado.apigeowork.entities.Autenticacion;
import org.albertorado.apigeowork.entities.PerfilEmpresa;
import org.albertorado.apigeowork.entities.PerfilUsuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.albertorado.apigeowork.repositories.AutenticacionRepository;
import org.albertorado.apigeowork.repositories.PerfilEmpresaRepository;
import org.albertorado.apigeowork.repositories.PerfilUsuarioRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class AutenticacionService {

    private final PerfilUsuarioRepository perfilUsuarioRepository;
    private final PerfilEmpresaRepository perfilEmpresaRepository;
    private final AutenticacionRepository autenticacionRepository;

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public AutenticacionService(PerfilUsuarioRepository perfilUsuarioRepository, PerfilEmpresaRepository perfilEmpresaRepository, AutenticacionRepository autenticacionRepository) {
        this.perfilUsuarioRepository = perfilUsuarioRepository;
        this.perfilEmpresaRepository = perfilEmpresaRepository;
        this.autenticacionRepository = autenticacionRepository;
    }

    public String generarToken(int idUsuario, String rol) {
        Date expiracion = Date.from(LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of(ZoneOffset.UTC.toString())));

        return Jwts.builder()
                .setSubject(String.valueOf(idUsuario))
                .claim("role", rol)
                .setIssuedAt(new Date())
                .setExpiration(expiracion)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    @Transactional
    public Autenticacion autenticacionUsuario(String email, String password, boolean tipoPerfil) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderProvider.getPasswordEncoder();


        System.out.println(email);
        if (tipoPerfil) {
            Optional<PerfilUsuario> perfilUsuario = perfilUsuarioRepository.findPerfilUsuarioByEmail(email);
            if (perfilUsuario.isPresent()) {
                if(passwordEncoder.matches(password, perfilUsuario.get().getPassword())) {
                    return generarTokenAutenticacion(perfilUsuario.get().getIdPerfil(), "PerfilUsuario", "USUARIO");
                }else{
                    System.out.println("password incorrecta");
                }
            }else{
                System.out.println("No se encuentra el email");
            }
        } else {
            Optional<PerfilEmpresa> perfilEmpresa = perfilEmpresaRepository.findPerfilEmpresaByEmail(email);
            if (perfilEmpresa.isPresent()) {
                if(passwordEncoder.matches(password, perfilEmpresa.get().getPassword())){
                    return generarTokenAutenticacion(perfilEmpresa.get().getIdUsuario(), "PerfilEmpresa", "EMPRESA");
                }else{
                    System.out.println("password incorrecta");
                }

            }else{
                System.out.println("No se encuentra el email");
            }
        }
        throw new Exception("Credenciales incorrectas");
    }

    private Autenticacion generarTokenAutenticacion(int idUsuario, String tipoPerfil, String rol) {
        Optional<Autenticacion> autenticacionExistente = autenticacionRepository.findByIdUsuarioAndTipoUsuario(idUsuario, tipoPerfil);

        String token = generarToken(idUsuario, rol);
        LocalDateTime fechaExpiracion = LocalDateTime.now().plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss.nnnnnnnnn");
        LocalDateTime fechaFinal = LocalDateTime.parse(fechaExpiracion.toString(), formatter);


        if (autenticacionExistente.isPresent()) {

            Autenticacion autenticacion = autenticacionExistente.get();
            autenticacion.setRefreshToken(token);
            autenticacion.setFechaExpiracion(fechaFinal);
            autenticacion.setRevocado(false);
            return autenticacionRepository.save(autenticacion);
        } else {
            Autenticacion nuevaAutenticacion = new Autenticacion();
            nuevaAutenticacion.setIdUsuario(idUsuario);
            nuevaAutenticacion.setTipoUsuario(tipoPerfil);
            nuevaAutenticacion.setRefreshToken(token);
            nuevaAutenticacion.setFechaExpiracion(fechaExpiracion);
            nuevaAutenticacion.setRol(rol);
            nuevaAutenticacion.setRevocado(false);
            return autenticacionRepository.save(nuevaAutenticacion);
        }
    }


    public boolean validarToken(String token) {
        String tokenLimpio = token.trim().replaceFirst("^Bearer\\s+", "");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(tokenLimpio)
                    .getBody();

            System.out.println("Token válido para el usuario: " + claims.getSubject());

            Optional<Autenticacion> autenticacionOpt = autenticacionRepository.findByRefreshToken(tokenLimpio);
            if (autenticacionOpt.isPresent()) {
                Autenticacion autenticacion = autenticacionOpt.get();

                if (autenticacion.getFechaExpiracion().isAfter(LocalDateTime.now()) && !autenticacion.isRevocado()) {
                    return true;
                } else {
                    System.out.println("El token ha expirado o está revocado.");
                }
            } else {
                System.out.println("Token no encontrado en la base de datos.");
            }
        } catch (MalformedJwtException e) {
            System.out.println("El token está mal formado: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Firma del token inválida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al validar el token: " + e.getMessage());
        }
        return false;
    }


    public void revocarToken(String token) {
        String tokenLimpio = token.trim().replaceFirst("^Bearer\\s+", "");
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(tokenLimpio)
                    .getBody();

            System.out.println("Token válido para el usuario: " + claims.getSubject());

            Optional<Autenticacion> autenticacionOpt = autenticacionRepository.findByRefreshToken(tokenLimpio);
            if (autenticacionOpt.isPresent()) {
                Autenticacion autenticacion = autenticacionOpt.get();
                autenticacion.setRevocado(true);
                autenticacionRepository.save(autenticacion);
            }else{
                System.out.println("hubo un problema el buscar el token: " + tokenLimpio);
            }
        }catch (MalformedJwtException e) {
            System.out.println("El token está mal formado: " + e.getMessage());
        } catch (SignatureException e) {
            System.out.println("Firma del token inválida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al validar el token: " + e.getMessage());
        }
    }

}
