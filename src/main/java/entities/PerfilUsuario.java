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
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_perfil",nullable = false)
    private int idPerfil;

    @Basic
    @Column(name = "password",nullable = false)
    private String password;


    private Trabajador idTrabajador;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

}
