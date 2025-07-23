package com.practica.notas_academicas.service;

import com.practica.notas_academicas.dto.AlumnoDto;
import com.practica.notas_academicas.mapper.AlumnoMapper;
import com.practica.notas_academicas.model.Alumno;
import com.practica.notas_academicas.repository.AlumnoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<AlumnoDto> listarAlumnos(){
        return alumnoRepository.findAll().stream()
                .map(AlumnoMapper::toDto)
                .collect(Collectors.toList());
    }

    public AlumnoDto obtenerAlumnoPorId(Long id){
        Alumno alumno = alumnoRepository.findById(id).orElse(null);
        return AlumnoMapper.toDto(alumno);
    }

    public AlumnoDto crearAlumno(AlumnoDto alumnoDto){
        Alumno alumno = AlumnoMapper.toEntity(alumnoDto);
        Alumno guardado = alumnoRepository.save(alumno);
        return AlumnoMapper.toDto(guardado);
    }

    public AlumnoDto actualizarAlumno(Long id, AlumnoDto alumnoDto){
        Alumno existente = alumnoRepository.findById(id).orElse(null);
        existente.setNombre(alumnoDto.getNombre());
        Alumno actualizado = alumnoRepository.save(existente);
        return AlumnoMapper.toDto(actualizado);
    }

    public void eliminarAlumno(Long id) {
        if (alumnoRepository.existsById(id)){
            alumnoRepository.deleteById(id);
        }
        throw new EntityNotFoundException("Alumno no encontrado con ID: "+ id);

    }

}
