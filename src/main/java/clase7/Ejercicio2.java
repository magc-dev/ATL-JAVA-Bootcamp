package clase7;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Después de realizar el ejercicio anterior, agregar que muestre el número mayor y el número menor.
 * @author magc-dev
 */
public class Ejercicio2 {
    public static void main(String[] args) {

        Ejercicio1.main(null);

        System.out.println();
        mostrarMenorMayor(Ejercicio1.numeros);
    }

    /**
     * Muestra el menor y mayor de los enteros del array que se le pase como argumento
     * @param numeros array de int que continene los números
     */
    protected static void mostrarMenorMayor(int[] numeros) {
        OptionalInt menor = Arrays.stream(numeros).min();
        OptionalInt mayor = Arrays.stream(numeros).max();

        if(menor.isPresent()) {
            System.out.println("El número menor es : " + menor.getAsInt());
            System.out.println("El número mayor es : " + mayor.getAsInt());
        }
    }
}
