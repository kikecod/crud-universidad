package com.example.CRUD.service;

import com.example.CRUD.dto.EstudianteDTO;
import com.example.CRUD.model.Materia;
import java.util.List;

public interface IEstudianteService {
    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    List<EstudianteDTO> obtenerEstudianteActivo();
    EstudianteDTO obtenerEstudiantePorNumeroInscripcion(String numeroInscripcion);
    List<Materia> obtenerMateriasDeEstudiante(Long estudianteId);
    EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO);
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    List<EstudianteDTO> buscarEstudiantesPorNombre(String nombre);
    List<EstudianteDTO> obtenerEstudiantesOrdenadosPorApellido();
}