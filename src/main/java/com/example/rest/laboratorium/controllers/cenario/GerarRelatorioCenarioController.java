package com.example.rest.laboratorium.controllers.cenario;

import com.example.rest.laboratorium.dtos.relatorio.RelatorioExecucaoCenarioDto;
import com.example.rest.laboratorium.repositories.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings({"unused"})
@Tag(name = "Cenarios")
@RestController
public class GerarRelatorioCenarioController {

    private final RelatorioExecucaoCenarioRepositorio relatorioRepositorio;

    public GerarRelatorioCenarioController(RelatorioExecucaoCenarioRepositorio gerarRelatorioRepositorio) {
        this.relatorioRepositorio = gerarRelatorioRepositorio;

    }

    @GetMapping("/api/cenarios/gerarRelatorio/{idCenario}")
    public ResponseEntity<RelatorioExecucaoCenarioDto> action(@PathVariable Long idCenario) {
        return ResponseEntity.ok(relatorioRepositorio.gerar(idCenario));
    }
}
