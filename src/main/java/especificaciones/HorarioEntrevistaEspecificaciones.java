package especificaciones;

import entities.HorarioEntrevista;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class HorarioEntrevistaEspecificaciones {

    public static Specification<HorarioEntrevista> tieneIdOferta(Integer idOferta) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (idOferta == null || idOferta == 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("idOferta"), idOferta);
        };

    }

    public static Specification<HorarioEntrevista> tieneDia(LocalDate dia) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (dia == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("dia"), dia);
        };
    }

    public static Specification<HorarioEntrevista> tieneHora(LocalTime hora) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (hora == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("hora"), hora);
        };
    }

    public static Specification<HorarioEntrevista> tieneCandidatosDisponibles(Integer candidatosDisponibles) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (candidatosDisponibles == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("candidatosDisponibles"), candidatosDisponibles);
        };
    }

    public static Specification<HorarioEntrevista> tieneCandidatosAsignados(Integer candidatosAsignados) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (candidatosAsignados == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("candidatosAsignados"), candidatosAsignados);
        };
    }

    public static Specification<HorarioEntrevista> tieneDisponibilidad() {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            return criteriaBuilder.lessThan(root.get("candidatosAsignados"), root.get("candidatosDisponibles"));
        };
    }
}
