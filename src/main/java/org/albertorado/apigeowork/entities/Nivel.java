package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Nivel {

    public Nivel(int idNivel, String nombreNivel, List<NivelEducativo> nivelesEducativos) {
        this.idNivel = idNivel;
        this.nombreNivel = nombreNivel;
        this.nivelesEducativos = nivelesEducativos;
    }

    public Nivel() {
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public @NotNull @Size(min = 0, max = 255) String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(@NotNull @Size(min = 0, max = 255) String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public List<NivelEducativo> getNivelesEducativos() {
        return nivelesEducativos;
    }

    public void setNivelesEducativos(List<NivelEducativo> nivelesEducativos) {
        this.nivelesEducativos = nivelesEducativos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel",nullable = false)
    private int idNivel;

    @NotNull
    @Size(min = 0,max = 255)
    @Basic
    @Column(name = "nombre_nivel",length = 255,nullable = false)
    private String nombreNivel;

    @OneToMany(mappedBy = "nivel")
    private List<NivelEducativo> nivelesEducativos;
}
