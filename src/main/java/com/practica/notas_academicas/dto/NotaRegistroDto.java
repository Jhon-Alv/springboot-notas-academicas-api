package com.practica.notas_academicas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaRegistroDto {

    private Long alumnoId;
    private Long cursoId;
    private Double clasificacion;

}
