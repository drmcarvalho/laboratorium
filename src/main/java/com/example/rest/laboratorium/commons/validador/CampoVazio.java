package com.example.rest.laboratorium.commons.validador;

public class CampoVazio {

    public static boolean validar(String str) {
        return str == null || str.trim().isEmpty();
    }

}
