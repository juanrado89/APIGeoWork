package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity

public class Documento {

    public Documento(int idDocumento, String nombre, String tipoContenido, @NotNull byte[] contenido, Experiencia experiencia) {
        this.idDocumento = idDocumento;
        this.nombre = nombre;
        this.tipoContenido = tipoContenido;
        this.contenido = contenido;
        this.experiencia = experiencia;
    }

    public Documento() {
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
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
    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(@NotNull byte[] contenido) {
        this.contenido = contenido;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento",nullable = true)
    private int idDocumento;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "nombre",length = 255,nullable = false)
    private String nombre;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "tipo_contenido",length = 255,nullable = false)
    private String tipoContenido;  // Para almacenar el tipo MIME del archivo (ej: "application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document")

    @NotNull
    @Lob
    @Basic
    @Column(name = "contenido",nullable = false)
    private byte[] contenido;

    @OneToOne(mappedBy = "cvUrl")
    private Experiencia experiencia;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdDocumento());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Documento documento = (Documento) obj;
        return idDocumento == documento.idDocumento;
    }
}
