package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.controllers.saida.ObterSaidaPorIdController;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
public class SaidaModelAssembler implements RepresentationModelAssembler<Saida, EntityModel<Saida>> {

    @Override
    public EntityModel<Saida> toModel(Saida saida) {
        return EntityModel.of(saida, linkTo(methodOn(ObterSaidaPorIdController.class).action(saida.getId())).withSelfRel());
    }
}
