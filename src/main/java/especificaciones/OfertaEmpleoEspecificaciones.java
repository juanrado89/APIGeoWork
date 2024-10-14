package especificaciones;

import org.springframework.data.jpa.domain.Specification;
import entities.OfertaEmpleo;

public class OfertaEmpleoEspecificaciones {

    // Especificación para el campo 'pais'
    public static Specification<OfertaEmpleo> tienePais(String pais) {
        return (root, query, criteriaBuilder) -> {
            if (pais == null || pais.isEmpty()) {
                return criteriaBuilder.conjunction();  // No agregar condición si el parámetro es nulo
            }
            return criteriaBuilder.like(root.get("pais"), "%" + pais + "%");
        };
    }

    // Especificación para el campo 'ciudad'
    public static Specification<OfertaEmpleo> tieneCiudad(String ciudad) {
        return (root, query, criteriaBuilder) -> {
            if (ciudad == null || ciudad.isEmpty()) {
                return criteriaBuilder.conjunction();  // No agregar condición si el parámetro es nulo
            }
            return criteriaBuilder.like(root.get("ciudad"),"%" +  ciudad + "%");
        };
    }

    // Especificación para el campo 'titulo'
    public static Specification<OfertaEmpleo> tieneTitulo(String titulo) {
        return (root, query, criteriaBuilder) -> {
            if (titulo == null || titulo.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
        };
    }

    // Especificación para el campo 'requisitos'
    public static Specification<OfertaEmpleo> tieneRequisitos(String requisitos) {
        return (root, query, criteriaBuilder) -> {
            if (requisitos == null || requisitos.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("requisitos"), "%" + requisitos + "%");
        };
    }

    // Especificación para el campo 'nivelEducativoRequerido'
    public static Specification<OfertaEmpleo> tieneNivelEducativo(String nivelEducativoRequerido) {
        return (root, query, criteriaBuilder) -> {
            if (nivelEducativoRequerido == null || nivelEducativoRequerido.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("nivelEducativoRequerido"),"%" +  nivelEducativoRequerido + "%");
        };
    }

    // Especificación para el salario mínimo (campo 'salarioMin')
    public static Specification<OfertaEmpleo> salarioMayorQue(Integer salarioMin) {
        return (root, query, criteriaBuilder) -> {
            if (salarioMin == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.greaterThanOrEqualTo(root.get("salarioMin"), salarioMin);
        };
    }

    // Especificación para el salario máximo (campo 'salarioMax')
    public static Specification<OfertaEmpleo> salarioMenorQue(Integer salarioMax) {
        return (root, query, criteriaBuilder) -> {
            if (salarioMax == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.lessThanOrEqualTo(root.get("salarioMax"), salarioMax);
        };
    }
}
