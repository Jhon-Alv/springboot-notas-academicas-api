package com.practica.notas_academicas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "alumnno_id")
    private Alummno alummno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private Double clasificacion;

}
