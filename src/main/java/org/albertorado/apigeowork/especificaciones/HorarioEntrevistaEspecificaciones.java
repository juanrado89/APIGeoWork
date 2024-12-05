package org.albertorado.apigeowork.especificaciones;

import org.albertorado.apigeowork.entities.HorarioEntrevista;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HorarioEntrevistaEspecificaciones {

    public static Specification<HorarioEntrevista> tieneIdOferta(Integer idOferta) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (idOferta == null || idOferta == 0) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("idOferta"), idOferta);
        };

    }

    public static Specification<HorarioEntrevista> tieneDia(String dia) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (dia == null || dia.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            try {
                LocalDate parsedDate = LocalDate.parse(dia, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                return criteriaBuilder.equal(root.get("dia"), parsedDate);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("El formato de la fecha no es válido. Se espera 'yyyy-MM-dd'.", e);
            }
        };
    }

    public static Specification<HorarioEntrevista> tieneHora(String hora) {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (hora == null || hora.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            try {
                LocalTime parsedTime = LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm:ss"));
                return criteriaBuilder.equal(root.get("hora"), parsedTime);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("El formato de la hora no es válido. Se espera 'HH:mm:ss'.", e);
            }
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
    public static Specification<HorarioEntrevista> ordenarPorDiaAscendente() {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("dia")));
            return criteriaBuilder.conjunction();
        };
    }
    public static Specification<HorarioEntrevista> ordenarPorHoraAscendente() {
        return (Root<HorarioEntrevista> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("hora")));
            return criteriaBuilder.conjunction();
        };
    }
}
