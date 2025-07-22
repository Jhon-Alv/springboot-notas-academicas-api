package com.practica.notas_academicas.mapper;

import com.practica.notas_academicas.dto.AlumnoDto;
import com.practica.notas_academicas.model.Alumno;

public class AlumnoMapper {

    public static AlumnoDto toDto(Alumno alumno) {
        if (alumno == null) return null;

        return AlumnoDto.builder()
                .id(alumno.getId())
                .nombre(alumno.getNombre())
                .build();
    }

    public static Alumno toEntity(AlumnoDto dto) {
        if (dto == null) return null;

        return Alumno.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .build();
    }

}
