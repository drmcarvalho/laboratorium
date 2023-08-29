package com.example.rest.laboratorium.controllers.saida;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.Saida;
import com.example.rest.laboratorium.models.SaidaModelAssembler;
import com.example.rest.laboratorium.repositories.SaidaRepositorio;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObterSaidaPorIdController {

    private final SaidaRepositorio repositorio;
    private final SaidaModelAssembler modelAssembler;

    public ObterSaidaPorIdController(SaidaRepositorio repositorio, SaidaModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/saidas/{id}")
    public EntityModel<Saida> action(@PathVariable Long id) {
        return modelAssembler.toModel(repositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException(id, "Saida")));
    }
}
