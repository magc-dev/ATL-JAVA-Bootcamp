package clase7;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Mostrar el promedio. Para hacer esto se suman todos los números y se divide por 5,
 * ya que el usuario agregó 5 números.
 * @author magc-dev
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Ejercicio2.main(null);

        promedio(Ejercicio1.numeros);
    }

    /**
     * Calcula el promedio de los números contenidos en el array de enteros pasado como argumento
     * @param numeros array de int con los números
     */
    protected static void promedio(int[] numeros) {
        OptionalDouble promedio = Arrays.stream(numeros).average();

        if(promedio.isPresent()) {
            System.out.println("El promedio es: " + promedio.getAsDouble());
        }
    }
}
