package clase5;

import java.util.Random;
import java.util.Scanner;

import clase5.Enums.TipoConversor;
import clase5.Enums.TipoCalculadora;

/**
 * Actividades clase 5
 * @author magc-dev
 */
public class Actividades {

    private static final int LIMITE_INFERIOR_NUMERO_ALEATORIO = 1;
    private static final int LIMITE_SUPERIOR_NUMERO_ALEATORIO = 100;
    private static final String INTRODUCIR_OPCION_TXT = "Introduzca número de opción elegida: ";
    private static final String OPCION_NUMERO_VALIDO_TXT = "Debe introducir un número del 0 al 5.";
    private static final String DESPEDIDA_TXT = "Muchas gracias!";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        byte opcion = 0;
        do {
            menu();
            boolean opcion_valida = true;
            do {
                System.out.print(INTRODUCIR_OPCION_TXT);
                try {
                    opcion = scanner.nextByte();
                    switch (opcion) {
                        case 0 -> opcion_valida = true;
                        case 1 -> conversor(TipoConversor.CONVERSOR_PERRO_PERSONA);
                        case 2 -> conversor(TipoConversor.CONVERSOR_MILLAS_KILOMETROS);
                        case 3 -> calculadora(TipoCalculadora.CALCULADORA_PRECIO_FINAL);
                        case 4 -> calculadora(TipoCalculadora.CALCULADORA_PROPINA);
                        case 5 -> juegoAdivinarNumero();
                        default -> System.out.println(OPCION_NUMERO_VALIDO_TXT);
                    }
                } catch (Exception e) {
                    System.out.println(OPCION_NUMERO_VALIDO_TXT);
                    opcion_valida = false;
                    scanner = new Scanner(System.in);
                }
            } while(!opcion_valida);
        } while(opcion != 0);
        System.out.println(DESPEDIDA_TXT);
    }

    /**
     * Muestra por pantalla el menú de opciones
     */
    private static void menu() {
        System.out.println("--------------- MENU ---------------");
        System.out.println("1 - Calculadora de edad de perros");
        System.out.println("2 - Conversor de millas a kilómetros");
        System.out.println("3 - Calculadora de descuento");
        System.out.println("4 - Calculadora de propinas");
        System.out.println("5 - Juego de adivinar número");
        System.out.println("0 - SALIR");
        System.out.println("------------------------------------");
    }

    /**
     * Convierte una cantidad en otra en función del tipo de conversor pasado como parámetro
     * @param tipo TipoConversor tipo del conversor (edad de persona a edad de perro o millas a km)
     */
    private static void conversor(TipoConversor tipo) {
        do {
            try {
                System.out.print(tipo.PROMPT_TXT);
                switch (tipo) {
                    case CONVERSOR_PERRO_PERSONA -> {
                        int entrada = scanner.nextInt();
                        if(entrada <= 0 || entrada > 120) {
                            System.out.println(tipo.OUT_OF_BOUNDS_TXT);
                            continue;
                        }
                        System.out.printf(tipo.RESULT_TXT, entrada, tipo.conversor.convierte(entrada));
                    }
                    case CONVERSOR_MILLAS_KILOMETROS -> {
                        float entrada = scanner.nextFloat();
                        if(entrada < 0) {
                            System.out.println(tipo.OUT_OF_BOUNDS_TXT);
                            continue;
                        }
                        System.out.printf(tipo.RESULT_TXT, entrada, tipo.conversor.convierte(entrada));
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(tipo.EXCEPTION_TXT);
                scanner = new Scanner(System.in);
            }
        } while(true);
    }

    /**
     * Calcula un resultado dadas dos entradas en función del tipo de calculadora pasado como parámetro
     * @param tipo TipoCalculadora tipo de la calculadora (precio final o propina)
     */
    private static void calculadora(TipoCalculadora tipo) {
        do {
            try {
                System.out.print(tipo.PROMPT_1_TXT);
                float entrada1 = scanner.nextFloat();
                System.out.print(tipo.PROMPT_2_TXT);
                float entrada2 = scanner.nextFloat();
                if(entrada1 < 0 || entrada2 < 0) {
                    System.out.println(tipo.OUT_OF_BOUNDS_TXT);
                    continue;
                }
                System.out.printf(tipo.RESULT_TXT, tipo.calculadora.calcula(entrada1, entrada2));
                break;
            } catch (Exception e) {
                System.out.println(tipo.EXCEPTION_TXT);
                scanner = new Scanner(System.in);
            }
        } while(true);
    }

    /**
     * Genera un número aleatorio entre 1 y 100 y pide al
     * usuario que lo adivine
     */
    private static void juegoAdivinarNumero() {
        int numeroAdivinar = new Random().nextInt(LIMITE_INFERIOR_NUMERO_ALEATORIO, LIMITE_SUPERIOR_NUMERO_ALEATORIO + 1);
        int intentos = 0;
        byte numero;
        do {
            try {
                System.out.print("Tu número: ");
                numero = scanner.nextByte();
                if(numero == 0) {
                    System.out.println("El número era: " + numeroAdivinar);
                    break;
                }
                if(numero < 0 || numero > 100) {
                    System.out.println("Tu número debe estar comprendido entre 1 y 100 (ambos inclusive).");
                    continue;
                }
                intentos++;
                if(numero == numeroAdivinar) {
                    System.out.println("CORRECTO!");
                    System.out.println("Has adivinado en (" + intentos + ") intentos.");
                    break;
                }
                if(numero > numeroAdivinar) {
                    System.out.println("Tu número es mayor.");
                } else {
                    System.out.println("Tu número es menor.");
                }
            } catch (Exception e) {
                System.out.println("Introduce un número válido (1 - 100) o 0 para salir.");
                scanner = new Scanner(System.in);
            }
        } while(true);
    }
}
