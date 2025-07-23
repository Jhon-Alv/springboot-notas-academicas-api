package com.practica.notas_academicas.repository;

import com.practica.notas_academicas.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}
