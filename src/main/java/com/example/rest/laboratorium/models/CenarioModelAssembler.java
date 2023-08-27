package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.controllers.cenario.ListarTodosCenariosController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CenarioModelAssembler implements RepresentationModelAssembler<Cenario, EntityModel<Cenario>> {

    @Override
    public EntityModel<Cenario> toModel(Cenario cenario) {
        return EntityModel.of(cenario, linkTo(methodOn(ListarTodosCenariosController.class).action())
                .withRel("/api/cenarios"));
    }
}
