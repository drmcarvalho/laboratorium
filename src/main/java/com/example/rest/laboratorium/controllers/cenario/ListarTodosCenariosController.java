package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.models.CenarioModelAssembler;
import com.example.rest.laboratorium.repositories.CenarioRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Cenarios")
public class ListarTodosCenariosController {
    private final CenarioRepositorio repositorio;
    private final CenarioModelAssembler modelAssembler;

    public ListarTodosCenariosController(CenarioRepositorio repositorio, CenarioModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/cenarios")
    public ResponseEntity<?> action() {
        var cenarios = repositorio.findAll();
        if (cenarios.isEmpty())
            return ResponseEntity.ok().body(cenarios);

        return ResponseEntity.ok(CollectionModel.of(repositorio
                .findAll()
                .stream()
                .map(modelAssembler::toModel)
                .toList(),
            linkTo(methodOn(ListarTodosCenariosController.class)).withSelfRel()));
    }
}
