package com.practica.notas_academicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaDto {
    private Long id;
    private Double clasificacion;
    private Long alumnoId;
    private Long cursoId;
}
