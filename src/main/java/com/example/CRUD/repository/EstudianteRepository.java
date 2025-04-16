package com.example.CRUD.repository;

import com.example.CRUD.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByNumeroInscripcion(String numeroInscripcion);
    Estudiante findByEstado(String estado);
    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
    List<Estudiante> findAllByOrderByApellidoAsc();
}
