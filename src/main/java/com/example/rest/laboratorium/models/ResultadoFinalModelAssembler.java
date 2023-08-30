package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.controllers.resultadofinal.ObterResultadoFinalPorCenario;
import com.example.rest.laboratorium.controllers.resultadofinal.ObterResultadoFinalPorId;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Configuration
public class ResultadoFinalModelAssembler implements RepresentationModelAssembler<ResultadoFinal, EntityModel<ResultadoFinal>> {

    @Override
    public EntityModel<ResultadoFinal> toModel(ResultadoFinal resultadoFinal) {
        return EntityModel.of(resultadoFinal,
                linkTo(methodOn(ObterResultadoFinalPorId.class).action(resultadoFinal.getId())).withSelfRel(),
                linkTo(methodOn(ObterResultadoFinalPorCenario.class, resultadoFinal.getIdCenario()).action(resultadoFinal.getIdCenario())).withRel("/api/resultadosfinais/obterPorIdCenario"));
    }
}
