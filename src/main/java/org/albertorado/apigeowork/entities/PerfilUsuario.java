package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albertorado.apigeowork.configuracion.MD5Util;
import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Objects;

@Entity
public class PerfilUsuario {

    public PerfilUsuario(int idPerfil, String password, Trabajador trabajador, String email, Foto foto, List<OfertaEmpleo> ofertas, List<HorarioEntrevista> horarios) {
        this.idPerfil = idPerfil;
        this.password = password;
        this.trabajador = trabajador;
        this.email = email;
        this.foto = foto;
        this.ofertas = ofertas;
        this.horarios = horarios;
    }

    public PerfilUsuario() {
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public @Size(min = 12, max = 50) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 12, max = 50) @NotNull String password) {
        this.password = password;
    }

    public @NotNull Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(@NotNull Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public @Size(min = 20, max = 255) @Email @NotNull String getEmail() {
        return email;
    }

    public void setEmail(@Size(min = 20, max = 255) @Email @NotNull String email) {
        this.email = email;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public List<OfertaEmpleo> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<OfertaEmpleo> ofertas) {
        this.ofertas = ofertas;
    }

    public List<HorarioEntrevista> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntrevista> horarios) {
        this.horarios = horarios;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil",nullable = false)
    private int idPerfil;

    @Basic
    @Size(min = 12, max = 50)
    @NotNull
    @Column(name = "password",nullable = false)
    private String password;

    @NotNull
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_trabajador", referencedColumnName = "id_trabajador")
    private Trabajador trabajador;

    @Basic
    @Size(min = 5, max = 255)
    @Email
    @NotNull
    @Column(name = "email",unique = true,length = 255,nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_foto", referencedColumnName = "id_foto")
    private Foto foto;

    @ManyToMany(mappedBy = "trabajadores")
    private List<OfertaEmpleo> ofertas;

    @ManyToMany(mappedBy = "trabajadores")
    private List<HorarioEntrevista> horarios;

    @PrePersist
    @PreUpdate
    private void encriptarPassword() {
        if (this.password != null) {
            this.password = PasswordEncoderProvider.getPasswordEncoder().encode(this.password);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPerfil());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PerfilUsuario perfil = (PerfilUsuario) obj;
        return idPerfil == perfil.idPerfil;
    }

}
