
from abc import ABC, abstractmethod

# EXCEPCIONES
class PagoInvalidoException(Exception):
    pass

class PromedioInvalidoException(Exception):
    pass

# INTERFACES
class Pagable(ABC):
    @abstractmethod
    def calcular_pago(self):
        pass

class Calificable(ABC):
    @abstractmethod
    def calcular_promedio(self):
        pass

# CLASE BASE
class Persona(ABC):
    def __init__(self, nombre, id_persona):
        self.nombre = nombre
        self.id_persona = id_persona

    @abstractmethod
    def mostrar_informacion(self):
        pass

# ESTUDIANTE
class Estudiante(Persona, Calificable):
    def __init__(self, nombre, id_estudiante, calificaciones):
        super().__init__(nombre, id_estudiante)
        if not calificaciones or not all(0 <= c <= 10 for c in calificaciones):
            raise PromedioInvalidoException("Calificaciones inválidas.")
        self.calificaciones = calificaciones

    def calcular_promedio(self):
        return sum(self.calificaciones) / len(self.calificaciones)

    def mostrar_informacion(self):
        print(f"Estudiante: {self.nombre} (ID: {self.id_persona}) - Promedio: {self.calcular_promedio():.2f}")

# PROFESOR TIEMPO COMPLETO
class ProfesorTiempoCompleto(Persona, Pagable):
    def __init__(self, nombre, id_profesor, salario_mensual):
        super().__init__(nombre, id_profesor)
        if salario_mensual <= 0:
            raise PagoInvalidoException("Salario inválido.")
        self.salario_mensual = salario_mensual

    def calcular_pago(self):
        return self.salario_mensual

    def mostrar_informacion(self):
        print(f"Profesor Tiempo Completo: {self.nombre} (ID: {self.id_persona}) - Salario: {self.salario_mensual}")

# PROFESOR POR HORAS
class ProfesorPorHoras(Persona, Pagable):
    def __init__(self, nombre, id_profesor, horas, tarifa):
        super().__init__(nombre, id_profesor)
        if horas <= 0 or tarifa <= 0:
            raise PagoInvalidoException("Horas y tarifa inválidas.")
        self.horas = horas
        self.tarifa = tarifa

    def calcular_pago(self):
        return self.horas * self.tarifa

    def mostrar_informacion(self):
        print(f"Profesor por Horas: {self.nombre} (ID: {self.id_persona}) - Pago: {self.calcular_pago()}")

# CURSO
class Curso:
    def __init__(self, nombre_curso, estudiantes, profesor):
        self.nombre_curso = nombre_curso
        self.estudiantes = estudiantes
        self.profesor = profesor

    def mostrar_informacion_curso(self):
        print(f"Curso: {self.nombre_curso}")
        print("Profesor asignado:")
        if isinstance(self.profesor, Persona):
            self.profesor.mostrar_informacion()
        print("Estudiantes:")
        for estudiante in self.estudiantes:
            estudiante.mostrar_informacion()

# MAIN
def main():
    try:
        prof_tc = ProfesorTiempoCompleto("Ana", "P001", 15000)
        prof_ph = ProfesorPorHoras("Luis", "P002", 40, 200)

        est1 = Estudiante("Carlos", "E001", [8.5, 9.0, 7.5])
        est2 = Estudiante("Maria", "E002", [9.5, 8.0, 10.0])
        estudiantes = [est1, est2]

        curso1 = Curso("Programación OO", estudiantes, prof_tc)
        curso2 = Curso("Bases de Datos", estudiantes, prof_ph)

        curso1.mostrar_informacion_curso()
        print()
        curso2.mostrar_informacion_curso()

    except (PagoInvalidoException, PromedioInvalidoException) as e:
        print(f"Error: {e}")

if __name__ == "__main__":
    main()
