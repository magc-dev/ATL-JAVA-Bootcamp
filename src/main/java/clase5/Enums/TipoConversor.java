package clase5.Enums;

import clase5.Interfaces.IConversor;

/**
 * Enum para el tipo de conversor
 * @author magc-dev
 */
public enum TipoConversor {
    CONVERSOR_PERRO_PERSONA(
            "Ingrese edad: ",
            "La edad humana debe estar comprendida entre 1 y 120 años.",
            "%d años de humano equivalen a %d años de perro.\n",
            "Ingrese una edad humana válida (1 - 120).",
            edad -> (int)edad * 7
    ),
    CONVERSOR_MILLAS_KILOMETROS(
            "Ingrese millas: ",
            "Ingrese una cantidad de millas mayor que 0.",
            "%f millas equivalen a %f kilómetros.\n",
            "Ingrese una cantidad de millas válida.",
            millas -> (float)millas * 1.60934f
    );

    public final String PROMPT_TXT;
    public final String OUT_OF_BOUNDS_TXT;
    public final String RESULT_TXT;
    public final String EXCEPTION_TXT;
    public final IConversor conversor;

    TipoConversor(String prompt, String bounds, String result, String exception, IConversor conversor) {
        PROMPT_TXT = prompt;
        OUT_OF_BOUNDS_TXT = bounds;
        RESULT_TXT = result;
        EXCEPTION_TXT = exception;
        this.conversor = conversor;
    }
}
