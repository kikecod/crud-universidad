package com.example.CRUD.controller;

import com.example.CRUD.dto.EstudianteDTO;
import com.example.CRUD.model.Materia;
import com.example.CRUD.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() {
        return ResponseEntity.ok(estudianteService.obtenerTodosLosEstudiantes());
    }

    @GetMapping("/inscripcion/{numeroInscripcion}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorNumeroInscripcion(@PathVariable String numeroInscripcion) {
        return ResponseEntity.ok(estudianteService.obtenerEstudiantePorNumeroInscripcion(numeroInscripcion));
    }

    @GetMapping("/{id}/materias")
    public ResponseEntity<List<Materia>> obtenerMateriasDeEstudiante(@PathVariable("id") Long estudianteId) {
        return ResponseEntity.ok(estudianteService.obtenerMateriasDeEstudiante(estudianteId));
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        return ResponseEntity.status(201).body(estudianteService.crearEstudiante(estudianteDTO));
    }

    @PutMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudianteDTO> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        return ResponseEntity.ok(estudianteService.actualizarEstudiante(id, estudianteDTO));
    }

    @GetMapping("/activos")
    public ResponseEntity<List<EstudianteDTO>> obtenerEstudianteActivo() {
        return ResponseEntity.ok(estudianteService.obtenerEstudianteActivo());
    }
    @GetMapping("/buscar")
    public ResponseEntity<List<EstudianteDTO>> buscarEstudiantesPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(estudianteService.buscarEstudiantesPorNombre(nombre));
    }

    @GetMapping("/ordenados-apellido")
    public ResponseEntity<List<EstudianteDTO>> obtenerEstudiantesOrdenadosPorApellido() {
        return ResponseEntity.ok(estudianteService.obtenerEstudiantesOrdenadosPorApellido());
    }
}