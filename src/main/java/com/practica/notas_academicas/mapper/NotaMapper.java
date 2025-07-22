package com.practica.notas_academicas.mapper;

import com.practica.notas_academicas.dto.NotaDetalleDto;
import com.practica.notas_academicas.dto.NotaDto;
import com.practica.notas_academicas.dto.NotaRegistroDto;
import com.practica.notas_academicas.model.Alumno;
import com.practica.notas_academicas.model.Curso;
import com.practica.notas_academicas.model.Nota;

public class NotaMapper {

    public static NotaDto toDto(Nota nota) {
        if (nota == null) return null;

        return NotaDto.builder()
                .id(nota.getId())
                .clasificacion(nota.getClasificacion())
                .alumnoId(nota.getAlumno().getId())
                .cursoId(nota.getCurso().getId())
                .build();
    }

    public static Nota toEntity(NotaRegistroDto dto, Alumno alumno, Curso curso) {
        if (dto == null) return null;

        return Nota.builder()
                .clasificacion(dto.getClasificacion())
                .alumno(alumno)
                .curso(curso)
                .build();
    }

    public static NotaDetalleDto toDetalleDto(Nota nota) {
        if (nota == null) return null;

        return NotaDetalleDto.builder()
                .nombreAlumno(nota.getAlumno().getNombre())
                .nombreCurso(nota.getCurso().getNombre())
                .calificacion(nota.getClasificacion()).build();
    }

}
