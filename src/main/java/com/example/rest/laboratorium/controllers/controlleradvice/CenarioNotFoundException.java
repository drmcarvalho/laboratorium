package com.example.rest.laboratorium.controllers.controlleradvice;

public class CenarioNotFoundException extends RuntimeException {

    public CenarioNotFoundException(Long id) {
        super("Não foi possivel localizar o cenário " + id);
    }
}
