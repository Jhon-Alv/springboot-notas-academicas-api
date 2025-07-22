package com.practica.notas_academicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaDetalleDto {

    private String nombreAlumno;
    private String nombreCurso;
    private Double calificacion;

}
