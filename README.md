# POO_en_Python
# Sistema de Gestión de Cursos Académicos Multilenguaje (Java → Python)

## Descripción General

Este proyecto desarrolla un sistema de gestión académica implementado en Java y posteriormente traducido a Python. Utiliza Programación Orientada a Objetos (POO) y aplica conceptos fundamentales como clases, herencia, polimorfismo, interfaces y excepciones personalizadas.

---

## Objetivos

* Diseñar e implementar un sistema de gestión de cursos utilizando los principios de POO.
* Aplicar:

  * Clases e instancias
  * Encapsulamiento
  * Herencia
  * Polimorfismo
  * Interfaces
  * Abstracción
  * Excepciones personalizadas
* Traducir el sistema de Java a Python adaptando su estructura.

---

## Escenario del Problema

La institución necesita un sistema para registrar estudiantes y profesores, gestionar cursos, calcular salarios y promedios, y lanzar errores lógicos mediante excepciones personalizadas.

El sistema debe:

* Registrar cursos y personas.
* Calcular el salario de profesores de tiempo completo y por horas.
* Calcular el promedio de calificaciones de estudiantes.
* Manejar errores mediante excepciones personalizadas.

---

## Requerimientos Funcionales

### 1. Clases e Interfaces

#### Interfaces:

* `Pagable` → `calcularPago()` (profesores)
* `Calificable` → `calcularPromedio()` (estudiantes)


#### Subclases de Persona:

```java
package personas;

public abstract class Persona {
    protected String nombre;
    protected String id;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public abstract void mostrarInformacion();
}
```

#### Clase Curso:

```java
package curso;
import interfaces.Pagable;
import java.util.List;
import personas.Estudiante;
import personas.Persona;

public class Curso  {
    private String nombreCurso;
    private List<Estudiante> estudiantes;
    private Pagable profesor;

    public Curso(String nombreCurso, List<Estudiante> estudiantes, Pagable profesor) {
        this.nombreCurso = nombreCurso;
        this.estudiantes = estudiantes;
        this.profesor = profesor;
    }

    public void mostrarInformacionCurso() {
        System.out.println("Curso: " + nombreCurso);
        System.out.println("Profesor asignado: ");
        if (profesor instanceof Persona persona) {
            persona.mostrarInformacion();
        }
        System.out.println("Estudiantes:");
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
        }
    }
}
```

---

### 2. Polimorfismo

Se demuestra en el procesamiento de listas heterogéneas de objetos que heredan de `Persona`:

```java
List<Persona> personas = Arrays.asList(profTC, profPH, est1, est2);
for (Persona p : personas) {
    System.out.println("- " + p.getNombre());
}
```



### 3. Excepciones Personalizadas

#### Definición:

```java
package excepciones;

public class PagoInvalidoException extends RuntimeException {
    public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
```

## Ejemplo de Ejecución en Java (Main.java)

```java
import curso.Curso;
import excepciones.PagoInvalidoException;
import excepciones.PromedioInvalidoException;
import java.util.Arrays;
import java.util.List;
import personas.Estudiante;
import personas.ProfesorPorHoras;
import personas.ProfesorTiempoCompleto;

public class Main {
    public static void main(String[] args) {
        try {
            ProfesorTiempoCompleto profTC = new ProfesorTiempoCompleto("Ana", "P001", 15000);
            ProfesorPorHoras profPH = new ProfesorPorHoras("Luis", "P002", 40, 200);

            Estudiante est1 = new Estudiante("Carlos", "E001", Arrays.asList(8.5, 9.0, 7.5));
            Estudiante est2 = new Estudiante("Maria", "E002", Arrays.asList(9.5, 8.0, 10.0));

            List<Estudiante> estudiantes = Arrays.asList(est1, est2);

            Curso curso1 = new Curso("Programacion OO", estudiantes, profTC);
            Curso curso2 = new Curso("Bases de Datos", estudiantes, profPH);

            curso1.mostrarInformacionCurso();
            System.out.println();
            curso2.mostrarInformacionCurso();

        } catch (PagoInvalidoException | PromedioInvalidoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

## Captura del funcionamiento
![image](https://github.com/user-attachments/assets/5cb20170-b7e4-4df0-8ecc-93fa98d4eaeb)







