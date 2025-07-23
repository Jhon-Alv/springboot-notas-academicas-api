package com.practica.notas_academicas.service;

import com.practica.notas_academicas.dto.NotaDetalleDto;
import com.practica.notas_academicas.dto.NotaDto;
import com.practica.notas_academicas.dto.NotaRegistroDto;
import com.practica.notas_academicas.mapper.NotaMapper;
import com.practica.notas_academicas.model.Alumno;
import com.practica.notas_academicas.model.Curso;
import com.practica.notas_academicas.model.Nota;
import com.practica.notas_academicas.repository.AlumnoRepository;
import com.practica.notas_academicas.repository.CursoRepository;
import com.practica.notas_academicas.repository.NotaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public List<NotaDto> listarNotas(){
        return notaRepository.findAll().stream()
                .map(NotaMapper::toDto)
                .collect(Collectors.toList());
    }

    public NotaDto obtenerNotaPorId(Long id){
        Nota nota = notaRepository.findById(id).orElse(null);
        return NotaMapper.toDto(nota);
    }

    public NotaDto registraNota(NotaRegistroDto dto){
        Alumno alumno = alumnoRepository.findById(dto.getAlumnoId())
                .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado con ID: "+ dto.getAlumnoId()));
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con ID: "+ dto.getCursoId()));

        Nota nota = Nota.builder()
                .alumno(alumno)
                .curso(curso)
                .clasificacion(dto.getClasificacion())
                .build();

        Nota guardada = notaRepository.save(nota);
        return NotaMapper.toDto(guardada);
    }

    public NotaDetalleDto notaDetalleDto(Long id){
        Nota nota = notaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota no encontrada con ID: "+ id));
        return NotaMapper.toDetalleDto(nota);
    }

    public void eliminarNora(Long id){
        if(notaRepository.existsById(id)){
            notaRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Nota no encontrada con ID: "+ id);
    }

}
