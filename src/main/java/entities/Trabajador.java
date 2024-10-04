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
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajador",nullable = false)
    private int idTrabajador;

    @OneToOne(mappedBy = "idTrabajador")
    private Datos datosUsuario;

    @OneToOne(mappedBy = "idTrabajador")
    private Experiencia datosExperiencia;

    @OneToOne(mappedBy = "idTrabajador")
    private PerfilUsuario perfil;

}
