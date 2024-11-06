package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity

public class Autenticacion {

    public Autenticacion(Long idAutenticacion, int idUsuario, String tipoUsuario, String refreshToken, LocalDateTime fechaExpiracion, String rol, boolean revocado, String ipAddress) {
        this.idAutenticacion = idAutenticacion;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.refreshToken = refreshToken;
        this.fechaExpiracion = fechaExpiracion;
        this.rol = rol;
        this.revocado = revocado;
        this.ipAddress = ipAddress;
    }

    public Autenticacion() {
    }

    public Long getIdAutenticacion() {
        return idAutenticacion;
    }

    public void setIdAutenticacion(Long idAutenticacion) {
        this.idAutenticacion = idAutenticacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isRevocado() {
        return revocado;
    }

    public void setRevocado(boolean revocado) {
        this.revocado = revocado;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutenticacion;

    @Column(nullable = false)
    private int idUsuario;

    @Column(nullable = false)
    private String tipoUsuario;

    @Column(nullable = false, unique = true)
    private String refreshToken;

    @Column(nullable = false)
    private LocalDateTime fechaExpiracion;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = false)
    private boolean revocado = false;

    @Column
    private String ipAddress;
}
