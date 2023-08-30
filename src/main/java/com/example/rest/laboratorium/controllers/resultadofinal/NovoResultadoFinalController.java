package com.example.rest.laboratorium.controllers.resultadofinal;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.ResultadoFinal;
import com.example.rest.laboratorium.models.ResultadoFinalModelAssembler;
import com.example.rest.laboratorium.repositories.ResultadoFinalRepositorio;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
@Tag(name = "Resultados")
public class NovoResultadoFinalController {

    private final ResultadoFinalRepositorio resultadoFinalRepositorio;
    private final ResultadoFinalModelAssembler modelAssembler;

    public NovoResultadoFinalController(ResultadoFinalRepositorio resultadoFinalRepositorio, ResultadoFinalModelAssembler modelAssembler) {
        this.resultadoFinalRepositorio = resultadoFinalRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @PostMapping("/api/resultadosfinais")
    public ResponseEntity<?> action(@RequestBody ResultadoFinal resultadoFinal) {
        if (CampoVazio.validar(resultadoFinal.getComentario()))
            return GerarRespostaBadRequest.resposta("Campo error", "Informe um comentario");
        if (resultadoFinalRepositorio.existsByIdCenario(resultadoFinal.getIdCenario()))
            return GerarRespostaBadRequest.resposta("Campo error", "Ja existe um resultado final para o cenario especificado");


        return ResponseEntity.ok(modelAssembler.toModel(resultadoFinalRepositorio.save(resultadoFinal)));
    }
}
