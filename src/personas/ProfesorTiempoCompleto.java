package personas;
import excepciones.PagoInvalidoException;
import interfaces.Pagable;

public class ProfesorTiempoCompleto extends Persona implements Pagable {
    private double salarioMensual;

    public ProfesorTiempoCompleto(String nombre, String id, double salarioMensual) throws PagoInvalidoException {
        super(nombre, id);
        if (salarioMensual <= 0) throw new PagoInvalidoException("Salario mensual inválido.");
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularPago() {
        return salarioMensual;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor TC: " + nombre + ", ID: " + id + ", Pago: " + calcularPago());
    }
}
