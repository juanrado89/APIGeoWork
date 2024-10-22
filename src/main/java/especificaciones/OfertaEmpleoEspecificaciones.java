package especificaciones;

import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;
import entities.OfertaEmpleo;

import java.sql.Timestamp;

public class OfertaEmpleoEspecificaciones {


    public static Specification<OfertaEmpleo> tienePais(String pais) {
        return (root, query, criteriaBuilder) -> {
            if (pais == null || pais.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("pais"), "%" + pais + "%");
        };
    }


    public static Specification<OfertaEmpleo> tieneCiudad(String ciudad) {
        return (root, query, criteriaBuilder) -> {
            if (ciudad == null || ciudad.isEmpty()) {
                return criteriaBuilder.conjunction();  // No agregar condición si el parámetro es nulo
            }
            return criteriaBuilder.like(root.get("ciudad"),"%" +  ciudad + "%");
        };
    }

    public static Specification<OfertaEmpleo> tieneEstado(String estado) {
        return (root, query, criteriaBuilder) -> {
            if (estado == null || estado.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("estado"),"%" +  estado + "%");
        };
    }


    public static Specification<OfertaEmpleo> tieneTitulo(String titulo) {
        return (root, query, criteriaBuilder) -> {
            if (titulo == null || titulo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
        };
    }


    public static Specification<OfertaEmpleo> tieneRequisitos(String requisitos) {
        return (root, query, criteriaBuilder) -> {
            if (requisitos == null || requisitos.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("requisitos"), "%" + requisitos + "%");
        };
    }


    public static Specification<OfertaEmpleo> tieneNivelEducativo(String nivelEducativoRequerido) {
        return (root, query, criteriaBuilder) -> {
            if (nivelEducativoRequerido == null || nivelEducativoRequerido.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("nivelEducativoRequerido"),"%" +  nivelEducativoRequerido + "%");
        };
    }

    public static Specification<OfertaEmpleo> salarioMayorQue(Float salarioMin) {
        return (root, query, criteriaBuilder) -> {
            if (salarioMin == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("salarioMin"), salarioMin);
        };
    }

    public static Specification<OfertaEmpleo> salarioMenorQue(Float salarioMax) {
        return (root, query, criteriaBuilder) -> {
            if (salarioMax == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("salarioMax"), salarioMax);
        };
    }
    public static Specification<OfertaEmpleo> estatus(Integer estatus) {
        return (root, query, criteriaBuilder) -> {

            if (estatus == null || estatus < 0 || estatus > 1) {
                return criteriaBuilder.conjunction();
            }

            return criteriaBuilder.equal(root.get("estatus"), estatus);
        };
    }

    public static Specification<OfertaEmpleo> ordenarPorFecha(boolean ascendente) {
        return (root, query, criteriaBuilder) -> {

            Path<Timestamp> fechaPublicacion = root.get("fechaPublicacion");


            if (ascendente) {
                query.orderBy(criteriaBuilder.asc(fechaPublicacion));
            } else {
                query.orderBy(criteriaBuilder.desc(fechaPublicacion));
            }

            return criteriaBuilder.conjunction();
        };
    }
}
