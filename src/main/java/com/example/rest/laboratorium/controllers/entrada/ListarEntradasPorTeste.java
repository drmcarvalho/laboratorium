package com.example.rest.laboratorium.controllers.entrada;

import com.example.rest.laboratorium.models.Entrada;
import com.example.rest.laboratorium.models.EntradaModelAssembler;
import com.example.rest.laboratorium.repositories.EntradaRepositorio;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.stream.Collectors;

@RestController
public class ListarEntradasPorTeste {

    private final EntradaRepositorio repositorio;
    private final EntradaModelAssembler modelAssembler;

    public ListarEntradasPorTeste(EntradaRepositorio repositorio, EntradaModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/entradas/listarPorIdTeste/{idTeste}")
    public CollectionModel<EntityModel<Entrada>> action(@PathVariable Long idTeste) {
        return CollectionModel.of(repositorio
                .findByIdTeste(idTeste)
                .stream()
                .map(modelAssembler::toModel)
                .collect(Collectors.toList()),
            linkTo(methodOn(ListarEntradasPorTeste.class).action(idTeste)).withSelfRel());
    }
}
