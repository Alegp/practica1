package practica1;

import java.util.Scanner;

/**
 * Esta clase permite realizar operaciones matemáticas básicas entre dos números ingresados por el usuario.
 */
public class Practica1 {

    /**
     * Método principal que inicia el programa y permite al usuario realizar operaciones matemáticas.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            double n1 = obtenerNumero(sc, "Introdueix el primer numero:");
            String operacion = obtenerOperacion(sc);
            double n2 = obtenerNumero(sc, "Introdueix el segon numero:");

            double resultado = calcularOperacion(n1, operacion, n2);

            System.out.println("(" + n1 + ") " + operacion + " (" + n2 + ")" + " = " + resultado);

            System.out.println("\nVols continuar operant? [s/n]");
        } while (sc.nextLine().equalsIgnoreCase("s"));
    }

    /**
     * Método que solicita al usuario un número válido.
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @param mensaje El mensaje que se muestra al usuario para solicitar el número.
     * @return El número válido introducido por el usuario.
     */
    private static double obtenerNumero(Scanner sc, String mensaje) {
        double numero;
        do {
            System.out.print(mensaje + " ");
            while (!sc.hasNextDouble()) {
                System.out.println("Introdueix un número vàlid.");
                sc.next();
            }
            numero = sc.nextDouble();
        } while (numero == 0);
        return numero;
    }

    /**
     * Método que solicita al usuario una operación válida.
     * @param sc El objeto Scanner utilizado para leer la entrada del usuario.
     * @return La operación válida introducida por el usuario.
     */
    private static String obtenerOperacion(Scanner sc) {
        String operacion;
        do {
            System.out.println("\nOperació? (Indica el signe)\n");
            System.out.println("+ = sumar \n- = restar \nx = multiplicar \n/ = dividir \n* = elevar primer num al segon num.\n% = residu");
            operacion = sc.nextLine();
        } while (!operacion.matches("[+\\-xX/*%]"));
        return operacion;
    }

    /**
     * Método que calcula el resultado de la operación especificada entre dos números.
     * @param n1 El primer número de la operación.
     * @param operacion La operación a realizar (por ejemplo, +, -, *, /, %).
     * @param n2 El segundo número de la operación.
     * @return El resultado de la operación matemática.
     */
    private static double calcularOperacion(double n1, String operacion, double n2) {
        double resultado = 0;
        switch (operacion) {
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "x":
            case "X":
                resultado = n1 * n2;
                break;
            case "/":
                resultado = n1 / n2;
                break;
            case "*":
                resultado = Math.pow(n1, n2);
                break;
            case "%":
                resultado = n1 % n2;
                break;
        }
        return resultado;
    }
}