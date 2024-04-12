package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            double n1 = obtenerNumero(scanner, "Introduce el primer número:");
            String operacion = obtenerOperacion(scanner);
            double n2 = obtenerNumero(scanner, "Introduce el segundo número:");

            double resultado = calcularOperacion(n1, operacion, n2);

            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ")" + " = " + resultado);

            System.out.println("\n¿Quieres continuar operando? [s/n]");
        } while (scanner.nextLine().equalsIgnoreCase("s"));
    }

    private static double obtenerNumero(Scanner scanner, String mensaje) {
        double numero;
        do {
            System.out.print(mensaje + " ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            numero = scanner.nextDouble();
        } while (numero == 0);
        return numero;
    }

    private static String obtenerOperacion(Scanner scanner) {
        String operacion;
        do {
            System.out.println("\n¿Qué operación deseas realizar? (Indica el símbolo)\n");
            System.out.println("+ = sumar \n- = restar \n* = multiplicar \n/ = dividir \n^ = elevar primer número al segundo número.\n% = residuo");
            operacion = scanner.nextLine();
        } while (!operacion.matches("[+\\-*/^%]"));
        return operacion;
    }

    private static double calcularOperacion(double n1, String operacion, double n2) {
        switch (operacion) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            case "^":
                return Math.pow(n1, n2);
            case "%":
                return n1 % n2;
            default:
                throw new IllegalArgumentException("Operación no válida: " + operacion);
        }
    }
}
