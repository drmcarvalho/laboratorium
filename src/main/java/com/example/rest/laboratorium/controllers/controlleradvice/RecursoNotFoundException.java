package com.example.rest.laboratorium.controllers.controlleradvice;

public class RecursoNotFoundException extends RuntimeException {

    public RecursoNotFoundException(Long id, String recurso) {
        super(String.format("Não foi possivel localizar o recurso %s para o Id: %d", recurso, id));
    }
}
