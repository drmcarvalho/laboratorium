package com.example.rest.laboratorium.commons.validador;

public class MaximoCaracteres {

    public static boolean validar(String str, Long maximo) {
        return str.length() > maximo;
    }
}
