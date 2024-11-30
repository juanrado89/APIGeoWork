package org.albertorado.apigeowork.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class OfertaEmpleo {

    public OfertaEmpleo(int idOferta, Empresa empresa, String titulo, int cantidad, String descripcion, Sector sector, String requisitos, Nivel nivel, float salarioMin, float salarioMax, Direccion direccion, Timestamp fechaPublicacion, int estado, List<HorarioEntrevista> horarios) {
        this.idOferta = idOferta;
        this.empresa = empresa;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.sector = sector;
        this.requisitos = requisitos;
        this.nivel = nivel;
        this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
        this.direccion = direccion;
        this.fechaPublicacion = fechaPublicacion;
        this.estado = estado;
        this.horarios = horarios;
    }

    public OfertaEmpleo() {
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public @NotNull Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(@NotNull Empresa empresa) {
        this.empresa = empresa;
    }

    public @Size(min = 0, max = 255) String getTitulo() {
        return titulo;
    }

    public void setTitulo(@Size(min = 0, max = 255) String titulo) {
        this.titulo = titulo;
    }

    @Digits(integer = 3, fraction = 0)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(@Digits(integer = 3, fraction = 0) int cantidad) {
        this.cantidad = cantidad;
    }

    public @NotNull @Size(min = 0, max = 3000) String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotNull @Size(min = 0, max = 3000) String descripcion) {
        this.descripcion = descripcion;
    }

    public @NotNull Sector getSector() {
        return sector;
    }

    public void setSector(@NotNull Sector sector) {
        this.sector = sector;
    }

    public @Size(min = 0, max = 3000) String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(@Size(min = 0, max = 3000) String requisitos) {
        this.requisitos = requisitos;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivelEducativo(Nivel nivel) {
        this.nivel = nivel;
    }

    @Digits(integer = 6, fraction = 2)
    public float getSalarioMin() {
        return salarioMin;
    }

    public void setSalarioMin(@Digits(integer = 6, fraction = 2) float salarioMin) {
        this.salarioMin = salarioMin;
    }

    @Digits(integer = 6, fraction = 2)
    public float getSalarioMax() {
        return salarioMax;
    }

    public void setSalarioMax(@Digits(integer = 6, fraction = 2) float salarioMax) {
        this.salarioMax = salarioMax;
    }

    public @NotNull Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotNull Direccion direccion) {
        this.direccion = direccion;
    }

    public @NotNull Timestamp getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(@NotNull Timestamp fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @NotNull
    @Digits(integer = 1, fraction = 0)
    public int getEstado() {
        return estado;
    }

    public void setEstado(@NotNull @Digits(integer = 1, fraction = 0) int estado) {
        this.estado = estado;
    }

    public List<HorarioEntrevista> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntrevista> horarios) {
        this.horarios = horarios;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oferta",nullable = false)
    private int idOferta;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", nullable = false, updatable = false)
    private Empresa empresa;

    @Basic
    @Size(min = 0,max = 255)
    @Column(name = "titulo",length = 255,nullable = false)
    private String titulo;

    @Basic
    @Digits(integer = 3,fraction = 0)
    @Column(name = "cantidad",precision = 3,nullable = false)
    private int cantidad;

    @NotNull
    @Size(min = 0,max = 3000)
    @Basic
    @Column(name = "descripcion",length = 3000,nullable = false)
    private String descripcion;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_sector", referencedColumnName = "id_sector", nullable = false, updatable = false)
    private Sector sector;

    @Size(min = 0,max = 3000)
    @Basic
    @Column(name = "requisitos",length = 3000,nullable = false)
    private String requisitos;

    @ManyToOne()
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", nullable = true, updatable = false)
    private Nivel nivel;

    @Basic
    @Digits(integer = 6, fraction = 2)
    @Column(name = "salario_min",precision = 8,nullable = false)
    private float salarioMin;

    @Basic
    @Digits(integer = 6, fraction = 2)
    @Column(name = "salario_max",precision = 8,nullable = false)
    private float salarioMax;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion", nullable = false, updatable = false)
    private Direccion direccion;

    @NotNull
    @Basic
    @Column(name = "fecha_publicacion",nullable = false)
    private Timestamp fechaPublicacion;

    @Basic
    @NotNull
    @Digits(integer = 1,fraction = 0)
    @Column(name = "estado",precision = 1,nullable = false)
    private int estado;

    @OneToMany(mappedBy = "ofertaEmpleo", cascade = CascadeType.ALL)
    private List<HorarioEntrevista> horarios;

    @ManyToMany()
    @JoinTable(name = "trabajadores_oferta", joinColumns = @JoinColumn(name = "id_oferta"), inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<PerfilUsuario> trabajadores;

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdOferta());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OfertaEmpleo oferta = (OfertaEmpleo) obj;
        return idOferta == oferta.idOferta;
    }

}
