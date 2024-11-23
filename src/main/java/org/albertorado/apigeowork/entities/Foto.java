package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity

public class Foto {

    public Foto(Long idFoto, String nombre, String tipoContenido, @NotNull String datos, PerfilEmpresa perfilEmpresa, PerfilUsuario perfilUsuario) {
        this.idFoto = idFoto;
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.datos = datos;
        this.perfilEmpresa = perfilEmpresa;
        this.perfilUsuario = perfilUsuario;
    }

    public Foto() {
    }

    public Long getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(Long idFoto) {
        this.idFoto = idFoto;
    }

    public @NotNull @Size(min = 0, max = 255) String getNombre() {
        return nombre;
    }

    public void setNombre(@NotNull @Size(min = 0, max = 255) String nombre) {
        this.nombre = nombre;
    }

    public @NotNull @Size(min = 0, max = 255) String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(@NotNull @Size(min = 0, max = 255) String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    @NotNull
    public String getDatos() {
        return datos;
    }

    public void setDatos(@NotNull String datos) {
        this.datos = datos;
    }

    public PerfilEmpresa getPerfilEmpresa() {
        return perfilEmpresa;
    }

    public void setPerfilEmpresa(PerfilEmpresa perfilEmpresa) {
        this.perfilEmpresa = perfilEmpresa;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto",nullable = true)
    private Long idFoto;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "nombre",length = 255,nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "tipo_contenido",length = 255,nullable = false)
    private String tipoContenido;  // MIME type, como "image/jpeg", "image/png", etc.

    @NotNull
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "datos", columnDefinition = "TEXT",nullable = false)
    private String datos;


    @OneToOne(mappedBy = "foto")
    private PerfilEmpresa perfilEmpresa;

    @OneToOne(mappedBy = "foto")
    private PerfilUsuario perfilUsuario;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdFoto());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Foto foto = (Foto) obj;
        return idFoto == foto.idFoto;
    }
}
