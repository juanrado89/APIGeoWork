package org.albertorado.apigeowork.services;

import jakarta.transaction.Transactional;
import org.albertorado.apigeowork.configuracion.MD5Util;
import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.albertorado.apigeowork.entities.Autenticacion;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
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
        String hashedPassword = MD5Util.hash(password);

        System.out.println(email);
        if (tipoPerfil) {
            Optional<PerfilUsuario> perfilUsuario = perfilUsuarioRepository.findPerfilUsuarioByEmail(email);
            if (perfilUsuario.isPresent()) {
                if(hashedPassword.equals(perfilUsuario.get().getPassword())){
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
                if(hashedPassword.equals(perfilEmpresa.get().getPassword())){
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

        if (autenticacionExistente.isPresent()) {

            Autenticacion autenticacion = autenticacionExistente.get();
            autenticacion.setRefreshToken(token);
            autenticacion.setFechaExpiracion(fechaExpiracion);
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
        Optional<Autenticacion> autenticacionOpt = autenticacionRepository.findByRefreshToken(token);
        if (autenticacionOpt.isPresent()) {
            Autenticacion autenticacion = autenticacionOpt.get();

            if (autenticacion.getFechaExpiracion().isAfter(LocalDateTime.now()) && !autenticacion.isRevocado()) {
                try {
                    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
                    return true;
                } catch (SignatureException e) {
                    System.err.println("Firma del token inválida: " + e.getMessage());
                }
            }
        }
        return false;
    }

    public void revocarToken(String token) {
        Optional<Autenticacion> autenticacionOpt = autenticacionRepository.findByRefreshToken(token);
        if (autenticacionOpt.isPresent()) {
            Autenticacion autenticacion = autenticacionOpt.get();
            autenticacion.setRevocado(true);
        }
    }

}
