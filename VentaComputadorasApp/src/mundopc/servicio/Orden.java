package mundopc.servicio;

import mundopc.modelo.Computadora;
import java.util.ArrayList;
import java.util.List;

public class Orden {
    // atributos
    private final int idOrden;
    private final List<Computadora> computadoras;
    private static int contadorOrdenes;

    // constructor
    public Orden() {
        computadoras = new ArrayList<>();
        this.idOrden = ++contadorOrdenes;
    }

    public void agregarComputadora(Computadora computadora) {
        computadoras.add(computadora);
    }

    public void mostrarOrden() {
        System.out.println("Orden #: " + idOrden);
        System.out.println("Total computadoras: " + computadoras.size());
        computadoras.forEach(System.out::println);
    }
}
