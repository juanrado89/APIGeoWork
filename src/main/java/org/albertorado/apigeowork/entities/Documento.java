package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

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
