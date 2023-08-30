package com.example.rest.laboratorium.controllers.resultadofinal;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.ResultadoFinal;
import com.example.rest.laboratorium.models.ResultadoFinalModelAssembler;
import com.example.rest.laboratorium.repositories.ResultadoFinalRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Resultados")
public class ObterResultadoFinalPorCenario {

    private final ResultadoFinalRepositorio resultadoFinalRepositorio;
    private final ResultadoFinalModelAssembler modelAssembler;

    public ObterResultadoFinalPorCenario(ResultadoFinalRepositorio resultadoFinalRepositorio,
                                         ResultadoFinalModelAssembler modelAssembler) {
        this.resultadoFinalRepositorio = resultadoFinalRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @GetMapping("/api/resultadosfinais/obterPorIdCenario/{idCenario}")
    public EntityModel<ResultadoFinal> action(@PathVariable Long idCenario) {
        return modelAssembler.toModel(resultadoFinalRepositorio.findByIdCenario(idCenario)
                .orElseThrow(() -> new RecursoNotFoundException(idCenario, "ResultadoFinal")));
    }
}
