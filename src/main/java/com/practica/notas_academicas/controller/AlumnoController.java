package com.practica.notas_academicas.controller;

import com.practica.notas_academicas.dto.AlumnoDto;
import com.practica.notas_academicas.service.AlumnoService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<AlumnoDto> listarAlumnos(){
        return alumnoService.listarAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDto> obtenerAlumno(@PathVariable Long id){
        AlumnoDto encontrado = alumnoService.obtenerAlumnoPorId(id);
        return ResponseEntity.ok(encontrado);
    }

    @PostMapping
    public ResponseEntity<AlumnoDto> crearAlumno(@RequestBody AlumnoDto alumnoDto){
        AlumnoDto creado = alumnoService.crearAlumno(alumnoDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDto> actualizarAlumno(@PathVariable Long id, @RequestBody AlumnoDto alumnoDto){
        AlumnoDto actulizado = alumnoService.actualizarAlumno(id, alumnoDto);
        return ResponseEntity.ok(actulizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id){
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }




}