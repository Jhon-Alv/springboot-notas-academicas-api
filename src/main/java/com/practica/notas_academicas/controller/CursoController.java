package com.practica.notas_academicas.controller;

import com.practica.notas_academicas.dto.CursoDto;
import com.practica.notas_academicas.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDto> listarCursos(){
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> obtenerCurso(@PathVariable Long id){
        CursoDto encontrado = cursoService.obtenerCursoPorId(id);
        return ResponseEntity.ok(encontrado);
    }

    @PostMapping
    public ResponseEntity<CursoDto> crearCurso(@RequestBody CursoDto cursoDto){
        CursoDto creado = cursoService.crearCurso(cursoDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDto> actualizarCurso(@PathVariable Long id, @RequestBody CursoDto cursoDto){
        CursoDto actualizado = cursoService.actualizarCurso(id, cursoDto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id){
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }

}
