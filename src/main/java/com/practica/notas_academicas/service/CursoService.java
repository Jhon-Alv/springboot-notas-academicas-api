package com.practica.notas_academicas.service;

import com.practica.notas_academicas.dto.CursoDto;
import com.practica.notas_academicas.mapper.CursoMapper;
import com.practica.notas_academicas.model.Curso;
import com.practica.notas_academicas.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoDto> listarCursos(){
        return cursoRepository.findAll().stream()
                .map(CursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CursoDto obtenerCursoPorId(Long id){
        Curso curso = cursoRepository.findById(id).orElse(null);
        return CursoMapper.toDto(curso);
    }

    public CursoDto crearCurso(CursoDto cursoDto){
        Curso curso = CursoMapper.toEntity(cursoDto);
        Curso guardado = cursoRepository.save(curso);
        return CursoMapper.toDto(curso);
    }

    public CursoDto actualizarCurso(Long id, CursoDto cursoDto){
        Curso curso = cursoRepository.findById(id).orElse(null);
        curso.setNombre(cursoDto.getNombre());
        Curso actualizado = cursoRepository.save(curso);
        return CursoMapper.toDto(curso);
    }

    public void eliminarCurso(Long id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Alumno no encontrado con ID: "+ id);
    }

}
