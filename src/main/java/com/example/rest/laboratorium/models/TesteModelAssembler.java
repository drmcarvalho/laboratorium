package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.controllers.cenario.ListarTodosCenariosController;
import com.example.rest.laboratorium.controllers.testes.*;
import com.example.rest.laboratorium.models.enums.TesteSituacao;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Configuration
public class TesteModelAssembler implements RepresentationModelAssembler<Teste, EntityModel<Teste>> {

    @Override
    public EntityModel<Teste> toModel(Teste teste) {
        EntityModel<Teste> testeEntityModel = EntityModel.of(teste,
                linkTo(methodOn(ObterTestePorIdController.class).action(teste.getId())).withSelfRel(),
                linkTo(methodOn(ObterTestePorCenarioController.class, teste.getIdCenario()).action(teste.getIdCenario())).withRel("/api/cenarios/testes"),
                linkTo(methodOn(ListarTodosCenariosController.class).action()).withRel("/api/cenarios"),
                linkTo(methodOn(ListarTodosTestesController.class).action()).withRel("/api/testes"));
        if (teste.getTesteSituacao() == TesteSituacao.EM_ANDAMENTO) {
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoFalhoController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/falho"));
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoOkController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/teste_ok"));
        } else if (teste.getTesteSituacao() == TesteSituacao.FALHO) {
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoAndamentoController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/em_andamento"));
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoOkController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/teste_ok"));
        } else if (teste.getTesteSituacao() == TesteSituacao.TESTE_OK) {
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoAndamentoController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/em_andamento"));
            testeEntityModel.add(linkTo(methodOn(DefinirTesteComoOkController.class, teste.getId()).action(teste.getId())).withRel("/api/testes/falho"));
        }
        return testeEntityModel;
    }
}
