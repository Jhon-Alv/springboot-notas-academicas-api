package com.practica.notas_academicas.repository;

import com.practica.notas_academicas.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
