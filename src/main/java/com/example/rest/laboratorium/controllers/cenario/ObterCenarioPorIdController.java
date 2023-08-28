package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.models.CenarioModelAssembler;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
public class ObterCenarioPorIdController {

    private final CenarioRepositorio repositorio;
    private final CenarioModelAssembler modelAssembler;

    public ObterCenarioPorIdController(CenarioRepositorio repositorio, CenarioModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/cenarios/{id}")
    public EntityModel<Cenario> action(@PathVariable Long id) {
        return modelAssembler.toModel(repositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException(id, "Cenario")));
    }
}
