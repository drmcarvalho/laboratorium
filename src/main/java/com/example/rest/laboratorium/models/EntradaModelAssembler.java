package com.example.rest.laboratorium.models;
import com.example.rest.laboratorium.controllers.entrada.ListarTodasEntradasPorTeste;
import com.example.rest.laboratorium.controllers.entrada.ObterEntradaPorId;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Configuration
public class EntradaModelAssembler implements RepresentationModelAssembler<Entrada, EntityModel<Entrada>>{

    @Override
    public EntityModel<Entrada> toModel(Entrada entrada) {
        return EntityModel.of(entrada,
                linkTo(methodOn(ObterEntradaPorId.class).action(entrada.getId())).withSelfRel(),
                linkTo(methodOn(ListarTodasEntradasPorTeste.class, entrada.getIdTeste()).action(entrada.getIdTeste())).withRel("/api/listarPorIdTeste/teste")
        );
    }
}
