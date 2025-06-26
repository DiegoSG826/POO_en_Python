package personas;
import excepciones.PromedioInvalidoException;
import interfaces.Calificable;
import java.util.List;

public class Estudiante extends Persona implements Calificable {
    private final List<Double> calificaciones;

    public Estudiante(String nombre, String id, List<Double> calificaciones) {
        super(nombre, id);
        this.calificaciones = calificaciones;
    }

    @Override
    public double calcularPromedio() {
        if (calificaciones == null || calificaciones.isEmpty()) {
            throw new PromedioInvalidoException("No hay calificaciones registradas.");
        }
        return calificaciones.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + nombre + ", ID: " + id + ", Promedio: " + calcularPromedio());
    }
}
