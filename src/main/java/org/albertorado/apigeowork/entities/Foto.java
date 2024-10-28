package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Foto {


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
    @Basic
    @Column(name = "datos",nullable = false)
    private byte[] datos;
}
