package com.example.CRUD.repository;

import com.example.CRUD.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByNumeroInscripcion(String numeroInscripcion);
    Estudiante findByEstado(String estado);
}
