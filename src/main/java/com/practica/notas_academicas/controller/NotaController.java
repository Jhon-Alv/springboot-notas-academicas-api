package com.practica.notas_academicas.controller;

import com.practica.notas_academicas.dto.NotaDetalleDto;
import com.practica.notas_academicas.dto.NotaDto;
import com.practica.notas_academicas.dto.NotaRegistroDto;
import com.practica.notas_academicas.dto.ReporteAlumnoDto;
import com.practica.notas_academicas.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<NotaDto> listarNotas(){
        return notaService.listarNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDto> obtenerNota(@PathVariable Long id){
        NotaDto encontrado = notaService.obtenerNotaPorId(id);
        return ResponseEntity.ok(encontrado);
    }

    @PostMapping
    public ResponseEntity<NotaDto> crearNota(@RequestBody NotaRegistroDto notaRegistroDto){
        NotaDto creado = notaService.registraNota(notaRegistroDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id){
        notaService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<NotaDetalleDto> obtenerNotaDetalle(@PathVariable Long id){
        NotaDetalleDto detalleEncontrado = notaService.notaDetalleDto(id);
        return ResponseEntity.ok(detalleEncontrado);
    }

    @GetMapping("/reporte")
    public List<ReporteAlumnoDto> listarReportePorAlumno(){
        return notaService.obtenerListaReporteAlumno();
    }

    @GetMapping("/reporte/{id}")
    public ResponseEntity<ReporteAlumnoDto> obtenerReporteAlumno(@PathVariable Long id){
        ReporteAlumnoDto encontrado = notaService.obtenerReporteAlumno(id);
        return ResponseEntity.ok(encontrado);
    }

}
