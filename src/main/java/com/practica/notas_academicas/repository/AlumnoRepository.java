package com.practica.notas_academicas.repository;

import com.practica.notas_academicas.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
}
