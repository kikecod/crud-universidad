package com.example.CRUD.service.impl;

import com.example.CRUD.dto.EstudianteDTO;
import com.example.CRUD.model.Estudiante;
import com.example.CRUD.model.Materia;
import com.example.CRUD.repository.EstudianteRepository;
import com.example.CRUD.service.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes() {
        return estudianteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EstudianteDTO obtenerEstudiantePorNumeroInscripcion(String numeroInscripcion) {
        Estudiante estudiante = estudianteRepository.findByNumeroInscripcion(numeroInscripcion);
        return convertToDTO(estudiante);
    }

    @Override
    public List<EstudianteDTO> obtenerEstudianteActivo() {
        return estudianteRepository.findAll().stream()
                .filter(estudiante -> "activo".equalsIgnoreCase(estudiante.getEstado()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Materia> obtenerMateriasDeEstudiante(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return estudiante.getMaterias();
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = convertToEntity(estudianteDTO);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return convertToDTO(estudianteGuardado);
    }

    @Override
    public EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO) {
        Estudiante estudianteExistente = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        estudianteExistente.setNombre(estudianteDTO.getNombre());
        estudianteExistente.setApellido(estudianteDTO.getApellido());
        estudianteExistente.setEmail(estudianteDTO.getEmail());
        estudianteExistente.setFechaNacimiento(estudianteDTO.getFechaNacimiento());
        estudianteExistente.setNumeroInscripcion(estudianteDTO.getNumeroInscripcion());
        estudianteExistente.setEstado(estudianteDTO.getEstado());
        estudianteExistente.setUsuarioAlta(estudianteDTO.getUsuarioAlta());
        estudianteExistente.setFechaAlta(estudianteDTO.getFechaAlta());
        estudianteExistente.setUsuarioModificacion(estudianteDTO.getUsuarioModificacion());
        estudianteExistente.setFechaModificacion(estudianteDTO.getFechaModificacion());
        estudianteExistente.setUsuarioBaja(estudianteDTO.getUsuarioBaja());
        estudianteExistente.setFechaBaja(estudianteDTO.getFechaBaja());
        estudianteExistente.setMotivoBaja(estudianteDTO.getMotivoBaja());
        Estudiante estudianteActualizado = estudianteRepository.save(estudianteExistente);
        return convertToDTO(estudianteActualizado);
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante) {
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fechaNacimiento(estudiante.getFechaNacimiento())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .estado(estudiante.getEstado())
                .usuarioAlta(estudiante.getUsuarioAlta())
                .fechaAlta(estudiante.getFechaAlta())
                .usuarioModificacion(estudiante.getUsuarioModificacion())
                .fechaModificacion(estudiante.getFechaModificacion())
                .usuarioBaja(estudiante.getUsuarioBaja())
                .fechaBaja(estudiante.getFechaBaja())
                .motivoBaja(estudiante.getMotivoBaja()
                ).build();
    }

    private Estudiante convertToEntity(EstudianteDTO estudianteDTO) {
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fechaNacimiento(estudianteDTO.getFechaNacimiento())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .estado(estudianteDTO.getEstado())
                .usuarioAlta(estudianteDTO.getUsuarioAlta())
                .fechaAlta(estudianteDTO.getFechaAlta())
                .usuarioModificacion(estudianteDTO.getUsuarioModificacion())
                .fechaModificacion(estudianteDTO.getFechaModificacion())
                .usuarioBaja(estudianteDTO.getUsuarioBaja())
                .fechaBaja(estudianteDTO.getFechaBaja())
                .motivoBaja(estudianteDTO.getMotivoBaja())
                .build();
    }
}