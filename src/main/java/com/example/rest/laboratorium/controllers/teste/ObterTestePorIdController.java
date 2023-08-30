package com.example.rest.laboratorium.controllers.teste;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.Teste;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Testes")
public class ObterTestePorIdController {

    private final TesteRepositorio repositorio;
    private final TesteModelAssembler modelAssembler;

    public ObterTestePorIdController(TesteRepositorio repositorio, TesteModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/testes/{id}")
    public EntityModel<Teste> action(@PathVariable Long id) {
        return modelAssembler.toModel(repositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException(id, "Teste")));
    }
}
