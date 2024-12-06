package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.albertorado.apigeowork.configuracion.MD5Util;
import org.albertorado.apigeowork.configuracion.PasswordEncoderProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

@Entity
public class PerfilEmpresa {

    public PerfilEmpresa(int idUsuario, String password, Empresa empresa, String email, Foto foto) {
        this.idUsuario = idUsuario;
        this.password = password;
        this.empresa = empresa;
        this.email = email;
        this.foto = foto;
    }

    public PerfilEmpresa() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public @Size(min = 12, max = 50) @NotNull String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 12, max = 50) @NotNull String password) {
        this.password = password;
    }

    public @NotNull Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NotNull Empresa empresa) {
        this.empresa = empresa;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private int idUsuario;

    @Basic
    @Size(min = 12, max = 50)
    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa")
    private Empresa empresa;

    @Basic
    @Size(min = 5, max = 255)
    @Email
    @NotNull
    @Column(name = "email",unique = true,length = 255,nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_foto", referencedColumnName = "id_foto")
    private Foto foto;


    @PrePersist
    @PreUpdate
    private void encriptarPassword() {
        if (this.password != null) {
            this.password = MD5Util.hash(this.password);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdUsuario());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PerfilEmpresa perfil = (PerfilEmpresa) obj;
        return idUsuario == perfil.idUsuario;
    }

}
