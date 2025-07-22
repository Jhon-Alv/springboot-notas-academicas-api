package com.practica.notas_academicas.mapper;

import com.practica.notas_academicas.dto.CursoDto;
import com.practica.notas_academicas.model.Curso;

public class CursoMapper {
    public static CursoDto toDto(Curso curso) {
        if (curso == null) return null;

        return CursoDto.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .build();
    }

    public static Curso toEntity(CursoDto dto) {
        if (dto == null) return null;

        return Curso.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }
}
