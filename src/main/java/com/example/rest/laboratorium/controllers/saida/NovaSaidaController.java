package com.example.rest.laboratorium.controllers.saida;

import com.example.rest.laboratorium.commons.resposta.GerarRespostaBadRequest;
import com.example.rest.laboratorium.commons.validador.CampoVazio;
import com.example.rest.laboratorium.models.Saida;
import com.example.rest.laboratorium.models.SaidaModelAssembler;
import com.example.rest.laboratorium.repositories.EntradaRepositorio;
import com.example.rest.laboratorium.repositories.SaidaRepositorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
public class NovaSaidaController {

    private final EntradaRepositorio entradaRepositorio;
    private final SaidaRepositorio saidaRepositorio;
    private final SaidaModelAssembler modelAssembler;

    public NovaSaidaController(EntradaRepositorio entradaRepositorio, SaidaRepositorio saidaRepositorio, SaidaModelAssembler modelAssembler) {
        this.entradaRepositorio = entradaRepositorio;
        this.saidaRepositorio = saidaRepositorio;
        this.modelAssembler = modelAssembler;
    }

    @PostMapping("/api/saidas")
    public ResponseEntity<?> action(@RequestBody Saida saida) {
        if (CampoVazio.validar(saida.getConteudo()))
            return GerarRespostaBadRequest.resposta("Campo error", "Informe o conteudo da saida gerada pela entrada do teste");
        if (saidaRepositorio.existsByIdEntrada(saida.getIdEntrada()))
            return GerarRespostaBadRequest.resposta("Campo error", "A entrada informada ja possui uma saida");
        if (!entradaRepositorio.findById(saida.getIdEntrada()).isPresent())
            return GerarRespostaBadRequest.resposta("Campo error", "A entrada informada não existe");

        return ResponseEntity.ok(modelAssembler.toModel(saidaRepositorio.save(saida)));
    }
}
