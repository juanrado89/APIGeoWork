package entities;

import jakarta.persistence.*;
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
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil",nullable = false)
    private int idPerfil;

    @Basic
    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne(mappedBy = "id_trabajador")
    private Trabajador idTrabajador;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @OneToOne(mappedBy = "id_foto")
    private Foto foto;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPerfil());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PerfilUsuario perfil = (PerfilUsuario) obj;
        return idPerfil == perfil.idPerfil;
    }

}
