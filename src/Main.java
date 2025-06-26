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
