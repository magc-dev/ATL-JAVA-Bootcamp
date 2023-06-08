package clase5.Enums;

import clase5.Interfaces.ICalculadora;

/**
 * Enum para el tipo de calculadora
 * @author magc-dev
 */
public enum TipoCalculadora {
    CALCULADORA_PRECIO_FINAL(
            "Introduce precio: ",
            "Introduce descuento: ",
            "El descuento y el porcentaje de descuento han de ser superiores a 0.",
            "Precio final: %f\n",
            "Ingrese un valor váido tanto para el precio como para el descuento.",
            (precio, descuento) -> precio - ((precio * (descuento / 100)))
    ),
    CALCULADORA_PROPINA(
            "Introduce valor de la cuenta: ",
            "Introduce porcentaje de propina: ",
            "La cuenta y el porcentaje de propina han de ser superiores a 0.",
            "Propina: %f\n",
            "Ingrese un valor váido tanto para la cuenta como para la propina.",
            (cuenta,propina) -> cuenta * (propina / 100)
    );

    public final String PROMPT_1_TXT;
    public final String PROMPT_2_TXT;
    public final String OUT_OF_BOUNDS_TXT;
    public final String RESULT_TXT;
    public final String EXCEPTION_TXT;
    public final ICalculadora<Float> calculadora;

    TipoCalculadora(String prompt1, String prompt2, String bounds, String result, String exception, ICalculadora<Float> calculadora) {
        PROMPT_1_TXT = prompt1;
        PROMPT_2_TXT = prompt2;
        OUT_OF_BOUNDS_TXT = bounds;
        RESULT_TXT = result;
        EXCEPTION_TXT = exception;
        this.calculadora = calculadora;
    }
}
