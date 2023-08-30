package com.example.rest.laboratorium.controllers.resultadofinal;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.dtos.ResultadoFinalComentarioDto;
import com.example.rest.laboratorium.models.ResultadoFinalModelAssembler;
import com.example.rest.laboratorium.repositories.ResultadoFinalRepositorio;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class AlterarComentarioResultadoFinalController {

    private final ResultadoFinalRepositorio resultadoFinalRepositorio;
    private final ResultadoFinalModelAssembler modelAssembler;

    public AlterarComentarioResultadoFinalController(ResultadoFinalRepositorio resultadoFinalRepositorio, ResultadoFinalModelAssembler modelAssembler) {
        this.resultadoFinalRepositorio = resultadoFinalRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @PatchMapping("/api/resultadosfinais/{id}")
    public ResponseEntity<?> action(@RequestBody ResultadoFinalComentarioDto comentarioDto, @PathVariable Long id) {
        if (CampoVazio.validar(comentarioDto.getComentario()))
            return GerarRespostaBadRequest.resposta("Campo error", "Informe um comentario");


        return ResponseEntity.ok(resultadoFinalRepositorio.findById(id)
                .map(alteracaoResultado -> {
                    alteracaoResultado.setComentario(comentarioDto.getComentario());
                    return modelAssembler.toModel(resultadoFinalRepositorio.save(alteracaoResultado));
                }).orElseThrow(() -> new RecursoNotFoundException(id, "ResultadoFinal"))
        );
    }
}
