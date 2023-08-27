package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.models.CenarioModelAssembler;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ListarTodosCenariosController {
    private final CenarioRepositorio repositorio;
    private final CenarioModelAssembler modelAssembler;

    public ListarTodosCenariosController(CenarioRepositorio repositorio, CenarioModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/cenarios")
    public CollectionModel<EntityModel<Cenario>> action() {
        return CollectionModel.of(repositorio
                .findAll()
                .stream()
                .map(modelAssembler::toModel)
                .collect(Collectors.toList()),
            linkTo(methodOn(ListarTodosCenariosController.class)).withSelfRel());
    }
}
