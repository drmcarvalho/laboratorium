package com.example.rest.laboratorium.controllers.teste;

import com.example.rest.laboratorium.models.Teste;
import com.example.rest.laboratorium.models.TesteModelAssembler;
import com.example.rest.laboratorium.repositories.TesteRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Testes")
public class ListarTodosTestesController {
    private final TesteRepositorio repositorio;
    private final TesteModelAssembler modelAssembler;

    public ListarTodosTestesController(TesteRepositorio repositorio, TesteModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/testes")
    public CollectionModel<EntityModel<Teste>> action() {
        return CollectionModel.of(repositorio
                .findAll()
                .stream()
                .map(modelAssembler::toModel)
                .collect(Collectors.toList()),
        linkTo(methodOn(ListarTodosTestesController.class).action()).withSelfRel());
    }
}
