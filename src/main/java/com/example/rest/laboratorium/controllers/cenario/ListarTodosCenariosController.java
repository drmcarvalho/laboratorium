package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListarTodosCenariosController {
    private final CenarioRepositorio repositorio;

    public ListarTodosCenariosController(CenarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/api/cenarios")
    ResponseEntity<List<Cenario>> action() {
        return ResponseEntity.ok(repositorio.findAll());
    }
}
