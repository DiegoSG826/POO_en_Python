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

#### Clase abstracta:

```java
public abstract class Persona {
    protected String nombre;
    protected String id;
    // Constructor y getters
}
```

#### Subclases de Persona:

```java
public class ProfesorTiempoCompleto extends Persona implements Pagable {
    private double salarioMensual;
    // calcularPago() lanza PagoInvalidoException
}

public class ProfesorPorHoras extends Persona implements Pagable {
    private int horasTrabajadas;
    private double pagoPorHora;
    // calcularPago() lanza PagoInvalidoException
}

public class Estudiante extends Persona implements Calificable {
    private List<Double> calificaciones;
    // calcularPromedio() lanza PromedioInvalidoException
}
```

#### Clase Curso:

```java
public class Curso {
    private String nombreCurso;
    private List<Estudiante> estudiantes;
    private Persona profesorAsignado;

    public void mostrarInformacionCurso() {
        // Muestra el nombre del curso, nombre del profesor y alumnos
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

Los objetos `profTC`, `profPH`, `est1`, `est2` son instancias de clases hijas pero tratados como tipo base `Persona`.

---

### 3. Excepciones Personalizadas

#### Definición:

```java
public class PagoInvalidoException extends Exception {
    public PagoInvalidoException(String msg) { super(msg); }
}

public class PromedioInvalidoException extends Exception {
    public PromedioInvalidoException(String msg) { super(msg); }
}
```

#### Uso:

```java
if (salarioMensual <= 0) throw new PagoInvalidoException("Pago inválido");
if (calificaciones.isEmpty()) throw new PromedioInvalidoException("No hay calificaciones");
```

---

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





