package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    @Size(min = 12, max = 50)
    @NotNull
    @Column(name = "password",length = 50,nullable = false)
    private String password;

    @NotNull
    @OneToOne(mappedBy = "id_empresa")
    private Empresa idEmpresa;

    @Basic
    @Size(min = 20, max = 255)
    @Email
    @NotNull
    @Column(name = "email",length = 255,nullable = false)
    private String email;

    @OneToOne(mappedBy = "id_foto")
    private Foto foto;

    @OneToMany(mappedBy = "idEmpresa")
    private List<OfertaEmpleo> ofertas;

    @PrePersist
    private void encriptarPassword() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(this.password);
    }

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
