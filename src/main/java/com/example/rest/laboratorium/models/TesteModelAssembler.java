package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.controllers.cenario.ListarTodosCenariosController;
import com.example.rest.laboratorium.controllers.testes.ListarTodosTestesController;
import com.example.rest.laboratorium.controllers.testes.ObterTestePorCenarioController;
import com.example.rest.laboratorium.controllers.testes.ObterTestePorIdController;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Configuration
public class TesteModelAssembler implements RepresentationModelAssembler<Teste, EntityModel<Teste>> {

    @Override
    public EntityModel<Teste> toModel(Teste teste) {
        return EntityModel.of(teste,
                linkTo(methodOn(ObterTestePorIdController.class).action(teste.getId())).withSelfRel(),
                linkTo(methodOn(ObterTestePorCenarioController.class).action(teste.getIdCenario())).withSelfRel(),
                linkTo(methodOn(ListarTodosCenariosController.class).action()).withRel("/api/cenarios"),
                linkTo(methodOn(ListarTodosTestesController.class).action()).withRel("/api/testes"));
    }
}
