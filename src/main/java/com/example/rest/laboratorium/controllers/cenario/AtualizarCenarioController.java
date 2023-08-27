package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.models.Cenario;
import com.example.rest.laboratorium.models.CenarioModelAssembler;
import com.example.rest.laboratorium.repositories.cenario.CenarioRepositorio;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AtualizarCenarioController {

    private final CenarioRepositorio repositorio;
    private final CenarioModelAssembler modelAssembler;

    public AtualizarCenarioController(CenarioRepositorio repositorio, CenarioModelAssembler modelAssembler) {
        this.repositorio = repositorio;
        this.modelAssembler = modelAssembler;
    }

    @PutMapping("/api/cenarios/{id}")
    public EntityModel<Cenario> action(@RequestBody Cenario cenario, @PathVariable Long id) {
        return repositorio.findById(id)
                .map(cenarioUpdate -> {
                    cenarioUpdate.setTitulo(cenario.getTitulo());
                    cenarioUpdate.setDescricao(cenario.getDescricao());
                    cenarioUpdate.setSituacao(cenario.getSituacao());
                    return modelAssembler.toModel(repositorio.save(cenarioUpdate));
                })
                .orElseGet(() -> {
                    cenario.setId(id);
                    return modelAssembler.toModel(repositorio.save(cenario));
                });
    }
}
