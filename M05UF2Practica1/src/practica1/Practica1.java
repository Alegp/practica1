package practica1;

import java.util.Scanner;

public class Practica1 {

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

    private static String obtenerOperacion(Scanner sc) {
        String operacion;
        do {
            System.out.println("\nOperació? (Indica el signe)\n");
            System.out.println("+ = sumar \n- = restar \nx = multiplicar \n/ = dividir \n* = elevar primer num al segon num.\n% = residu");
            operacion = sc.nextLine();
        } while (!operacion.matches("[+\\-xX/*%]"));
        return operacion;
    }

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