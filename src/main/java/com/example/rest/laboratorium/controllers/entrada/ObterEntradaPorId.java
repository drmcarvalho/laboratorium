package com.example.rest.laboratorium.controllers.entrada;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.EntradaModelAssembler;
import com.example.rest.laboratorium.repositories.EntradaRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
public class ObterEntradaPorId {

    private final EntradaRepositorio repositorio;
    private final EntradaModelAssembler modelAssembler;

    public ObterEntradaPorId(EntradaRepositorio repositorio, EntradaModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/entradas/{id}")
    public ResponseEntity<?> action(@PathVariable Long id) {
        return ResponseEntity.ok(modelAssembler.toModel(repositorio.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException(id, "Entrada"))));
    }
}
