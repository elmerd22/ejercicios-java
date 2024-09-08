import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        // llamado para capturar datos por consola
        Scanner console = new Scanner(System.in);
        // llamado para formatear resultado a 2 decimales
        DecimalFormat df = new DecimalFormat("###.##");

        // while que sirve para volver a mostrar el menu en caso que se digite un numero incorrecto o un string
        while (true) {
            System.out.println("\n***** Aplicación Calculadora *****");
            // Mostramos el menú
            mostrarmenu();
            // try sirve para capturar errores por ingreso de letras o caracteres
            try {
                var operacion = Integer.parseInt(console.nextLine());
                // Revisar que este dentro de las opciones mencionadas
                if (operacion >= 1 && operacion <= 4) {
                    // Ejecutamos la operacion deseada
                    ejecutarOperacion(operacion, console, df);
                } else if (operacion == 5) {
                    System.out.println("Hasta pronto...");
                    break;
                } else {//en caso que se digite un numero fuera de 1 - 5 este else hace volver a inicio
                    System.out.println("Opción erronea: " + operacion);
                }
            } //fin try
            catch (Exception e) { // captura y muestra el error por ingresar string o caracteres especiales
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        } //fin while
    } //fin main

    private static void mostrarmenu() {
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
        System.out.print("¿Qué operación desea realizar?:  ");
    }

    private static void ejecutarOperacion(int operacion, Scanner console, DecimalFormat df) {
        System.out.print("Proporciona el primer número: ");
        var numero1 = Double.parseDouble(console.nextLine());
        System.out.print("Proporciona el segundo número: ");
        var numero2 = Double.parseDouble(console.nextLine());

        Double resultado;

        switch (operacion) {
            case 1 -> {
                resultado = numero1 + numero2;
                System.out.println("Resultado Suma: " + df.format(resultado));
            }
            case 2 -> {
                resultado = numero1 - numero2;
                System.out.println("Resultado Resta: " + df.format(resultado));
            }
            case 3 -> {
                resultado = numero1 * numero2;
                System.out.println("Resultado Multiplicación: " + df.format(resultado));
            }
            case 4 -> {
                if(numero2 == 0) {
                    System.out.println("No se puede dividir por cero.");
                }
                else {
                    resultado = numero1 / numero2;
                    System.out.println("Resultado División: " + df.format(resultado));
                }
            }
            default -> System.out.println("Opción erronea: " + operacion);
        } //fin switch operaciones
    } //fin ejecutar operacion
} //fin clase
