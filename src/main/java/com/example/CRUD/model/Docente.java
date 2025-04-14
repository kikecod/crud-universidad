package com.example.CRUD.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "docente")
public class Docente extends Persona {
    @Column(name = "nro_empleado", nullable = false, unique = true)
    private String nroEmpleado;

    @Column(name = "departamento", nullable = false)
    private String departamento;
}