package com.example.CRUD.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity // Anotación que indica que esta clase es una entidad JPA
@Table(name = "persona") // Nombre de la tabla en la base de datos

@Inheritance(strategy = InheritanceType.JOINED) // Estrategia deherencia para JPA
public abstract class Persona {
    // Atributos de la clase Persona
    @Id // Anotación que indica que este campo es la clave primaria
    @Column(name = "id_persona") // Nombre de la columna en la basede datos
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generación automática del ID
    private Long id;
    @Column(nullable = false, length = 50) // Columna no nula conlongitud máxima de 50 caracteres
    private String nombre;
    @Column(nullable = false, length = 50) // Columna no nula conlongitud máxima de 50 caracteres
    private String apellido;
    @Column(nullable = false, unique = true) // Columna no nula ycon valor único
    private String email;
    @Column(name = "fecha_nacimiento", nullable = false) // Columnano nula con nombre personalizado
    @Temporal(TemporalType.DATE) // Tipo de dato fecha
    @Basic(optional = false) // Columna no nula
    private LocalDate fechaNacimiento;
}