package com.practica.notas_academicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReporteAlumnoDto {

    private String nombreAlumno;
    private Double promedio;
    private String estado;

}
