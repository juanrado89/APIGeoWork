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
public class Foto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto",nullable = true)
    private Long idFoto;

    private String nombre;

    private String tipoContenido;  // MIME type, como "image/jpeg", "image/png", etc.

    @Lob
    private byte[] datos;
}
