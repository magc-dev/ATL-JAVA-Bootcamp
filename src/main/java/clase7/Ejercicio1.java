package clase7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hacer un programa que permita al usuario ingresar 5 números y mostrarlos.
 * @author magc-dev
 */
public class Ejercicio1 {
    protected static final int NUMEROS_A_INGRESAR = 5;
    protected static int[] numeros;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numeros = new int[NUMEROS_A_INGRESAR];

        for(int i = 0; i < NUMEROS_A_INGRESAR; i++) {
            System.out.print("Ingresa número " + (i + 1) + ": ");
            try {
                numeros[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }

        System.out.print("Has ingresado los siguientes números: ");
        System.out.print(Arrays.toString(numeros));
    }
}
