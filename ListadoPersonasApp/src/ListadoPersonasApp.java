import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos con el menu
        var salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOperacion(console, personas);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        // Mostramos las opciones
        System.out.println("""
                ***** Listado Personas App *****
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporciona la opción? ");
    }

    private static boolean ejecutarOperacion(Scanner console, List<Persona> personas) {
        var opcion = Integer.parseInt(console.nextLine());
        var salir = false;
        // Revisamos la opcion proporcionada
        switch (opcion) {
            case 1 -> { // Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                var nombre = console.nextLine();
                System.out.print("Proporciona el teléfono: ");
                var tel = console.nextLine();
                System.out.print("Proporciona el email: ");
                var email = console.nextLine();
                // Crear el objeto persona
                var persona = new Persona(nombre, tel, email);
                // Agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            } // fin caso 1
            case 2 -> { // Listar las personas
                System.out.println("Listado de Personas: ");
                // Mejora usando lambda y metodo de referencia
                // personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            } // fin caso 2
            case 3 -> { // Salimos de ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            } // fin caso 3
            default -> {
                System.out.println("Opción erronea: " + opcion);
            }
        } // fin switch
        return salir;
    } // fin ejecutar operacion
} // fin listado personas app
