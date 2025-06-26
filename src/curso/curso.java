package src.curso;
import java.util.List;

public class Curso {
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
        if (profesor instanceof Persona) {
            ((Persona) profesor).mostrarInformacion();
        }
        System.out.println("Estudiantes:");
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
        }
    }
}
