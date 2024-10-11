package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario",nullable = false)
    private int idUsuario;

    @Basic
    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne(mappedBy = "id_empresa")
    private Empresa idEmpresa;

    @Basic
    @Column(name = "email",nullable = false)
    private String email;

    @OneToOne(mappedBy = "id_foto")
    private Foto foto;

    @OneToMany(mappedBy = "idEmpresa")
    private List<OfertaEmpleo> ofertas;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdUsuario());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PerfilEmpresa perfil = (PerfilEmpresa) obj;
        return idUsuario == perfil.idUsuario;
    }

}
