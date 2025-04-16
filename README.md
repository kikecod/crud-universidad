
⸻

🎓 Sistema de Gestión de Estudiantes

Este proyecto es una aplicación básica desarrollada con Java + Spring Boot que permite gestionar estudiantes mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

La aplicación sigue una arquitectura clara basada en capas:

`	`•	📁 Entidad: Define la estructura de datos (Estudiante).

`	`•	💾 Repository: Acceso a la base de datos.

`	`•	⚙️ Servicio: Lógica de negocio.

`	`•	🎯 Controlador: Exposición de endpoints REST.

⸻

💡 Tecnologías Usadas

`	`•	Java 17+

`	`•	Spring Boot

`	`•	Spring Data JPA

`	`•	H2 / MySQL

`	`•	Maven

`	`•	Postman (para pruebas de endpoints)

⸻

🚀 Funcionalidades Principales

`	`•	Registrar estudiantes.

`	`•	Listar todos los estudiantes.

`	`•	Buscar estudiantes por ID.

`	`•	Actualizar información de estudiantes.

`	`•	Eliminar estudiantes.

⸻

🔥 NUEVAS FUNCIONALIDADES IMPLEMENTADAS

Se añadieron dos nuevas operaciones al sistema para mejorar la gestión de estudiantes:

1️⃣ Buscar Estudiantes por Nombre

Permite buscar estudiantes que contengan un texto específico en su nombre, sin importar mayúsculas o minúsculas.

Endpoint:

GET /api/estudiantes/buscar?nombre={nombre}

📌 Ejemplo:

GET /api/estudiantes/buscar?nombre=Juan



⸻

2️⃣ Listar Estudiantes Ordenados por Apellido

Devuelve la lista de todos los estudiantes, ordenados de forma ascendente por su apellido.

Endpoint:

GET /api/estudiantes/ordenados-apellido



⸻

💻 Estructura de Carpetas

src

└── main

└── java

└── com.ejemplo.estudiantes

├── controller

│    └── EstudianteController.java

├── dto

│    └── EstudianteDTO.java

├── entity

│    └── Estudiante.java

├── repository

│    └── EstudianteRepository.java

└── service

├── IEstudianteService.java

└── EstudianteServiceImpl.java



⸻

⚙️ Ejecución

`	`1.	Clonar el repositorio.

`	`2.	Configurar el application.properties.

`	`3.	Levantar la aplicación desde tu IDE o usando:

mvn spring-boot:run

`	`4.	Probar los endpoints con Postman.

⸻

✍️ Contribuciones

¡Las contribuciones son bienvenidas!

Puedes crear un fork, proponer mejoras o reportar errores.

⸻

