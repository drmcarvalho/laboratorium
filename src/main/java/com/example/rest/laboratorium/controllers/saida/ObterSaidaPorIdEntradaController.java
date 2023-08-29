package com.example.rest.laboratorium.controllers.saida;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.models.Saida;
import com.example.rest.laboratorium.models.SaidaModelAssembler;
import com.example.rest.laboratorium.repositories.SaidaRepositorio;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused", "ClassCanBeRecord"})
@RestController
public class ObterSaidaPorIdEntradaController {

    private final SaidaRepositorio saidaRepositorio;
    private final SaidaModelAssembler modelAssembler;

    public ObterSaidaPorIdEntradaController(SaidaRepositorio saidaRepositorio, SaidaModelAssembler modelAssembler) {
        this.saidaRepositorio = saidaRepositorio;
        this.modelAssembler = modelAssembler;
    }
    
    @GetMapping("/api/saidas/obterPorIdEntrada/{idEntrada}")
    public EntityModel<Saida> action(@PathVariable Long idEntrada) {
        return modelAssembler.toModel(saidaRepositorio.findByIdEntrada(idEntrada)
                .orElseThrow(() -> new RecursoNotFoundException(idEntrada, "Saida")));
    }
}
