package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento",nullable = false)
    private int idDocumento;

    @Basic
    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Basic
    @Column(name = "tipo_contenido",nullable = false)
    private String tipoContenido;  // Para almacenar el tipo MIME del archivo (ej: "application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document")


    @Lob  // Anotación para grandes objetos (BLOB)
    @Basic
    @Column(name = "contenido",nullable = false)
    private byte[] contenido;
}
