package com.example.rest.laboratorium.controllers.testes;

import com.example.rest.laboratorium.repositories.teste.TesteRepositorio;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarTodosTestesController {
    private final TesteRepositorio repositorio;

    public ListarTodosTestesController(TesteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

}
