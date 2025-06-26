package personas;
import excepciones.PagoInvalidoException;
import interfaces.Pagable;


public class ProfesorPorHoras extends Persona implements Pagable {
    private int horasTrabajadas;
    private double pagoPorHora;

    public ProfesorPorHoras(String nombre, String id, int horasTrabajadas, double pagoPorHora) {
        super(nombre, id);
        if (horasTrabajadas * pagoPorHora <= 0) throw new PagoInvalidoException("Pago por horas inválido.");
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    @Override
    public double calcularPago() {
        return horasTrabajadas * pagoPorHora;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor PH: " + nombre + ", ID: " + id + ", Pago: " + calcularPago());
    }
}
