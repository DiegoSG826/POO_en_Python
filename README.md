# POO_en_Python
# Sistema de Gestión de Cursos Académicos Multilenguaje (Java → Python)

## Descripción General

Este proyecto tiene como objetivo desarrollar un sistema de gestión académica en dos lenguajes de programación (Java y Python), aplicando conceptos fundamentales de la Programación Orientada a Objetos (POO), tales como clases, encapsulamiento, herencia, polimorfismo, interfaces y manejo de excepciones personalizadas.

---

## Objetivos

- Desarrollar un sistema completo utilizando **Programación Orientada a Objetos (POO)**.
- Aplicar los conceptos clave de POO:
  - Clases e instancias
  - Encapsulamiento
  - Herencia
  - Polimorfismo
  - Abstracción
  - Interfaces
  - Excepciones personalizadas
- Traducir el sistema de **Java a Python**, adaptando las estructuras del lenguaje.

---

## Escenario del problema

La institución requiere un sistema para registrar profesores y estudiantes, así como administrar los cursos donde interactúan. El sistema debe:

- Registrar cursos y personas.
- Calcular salarios de profesores (tiempo completo y por horas).
- Calcular promedio de calificaciones de los estudiantes.
- Lanzar **excepciones personalizadas** en casos de errores de lógica.

---

## Requerimientos Funcionales

### 1. Clases e Interfaces

#### Interfaces:
- `Pagable` → método `calcularPago()` para profesores.
- `Calificable` → método `calcularPromedio()` para estudiantes.

#### Clase abstracta:
- `Persona`:
  - Atributos: `nombre`, `id`.

#### Subclases de Persona:
- `ProfesorTiempoCompleto`:
  - Atributo adicional: `salarioMensual`.
- `ProfesorPorHoras`:
  - Atributos adicionales: `horasTrabajadas`, `pagoPorHora`.
- `Estudiante`:
  - Atributo adicional: `listaCalificaciones` (`List<Double>`).

#### Clase:
- `Curso`:
  - Atributos: `nombreCurso`, `listaEstudiantes`, `profesorAsignado`.

---

### 2. Polimorfismo

- Procesamiento de listas de objetos `Persona` y `Curso` usando polimorfismo para mostrar su información.

---

### 3. Excepciones Personalizadas

- `PagoInvalidadoException`: se lanza si el pago de un profesor es menor o igual a cero.
- `PromedioInvalidoException`: se lanza si un estudiante no tiene calificaciones registradas.

---

## Estructura del Proyecto

