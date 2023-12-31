package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.dtos.relatorio.EntradaSaidaDto;
import com.example.rest.laboratorium.dtos.relatorio.RelatorioExecucaoCenarioDto;
import com.example.rest.laboratorium.dtos.relatorio.TesteDto;

import org.springframework.stereotype.Component;

@SuppressWarnings({"ClassCanBeRecord"})
@Component
public class RelatorioExecucaoCenarioRepositorio {

    private final CenarioRepositorio cenarioRepositorio;
    private final EntradaRepositorio entradaRepositorio;
    private final TesteRepositorio testeRepositorio;
    private final SaidaRepositorio saidaRepositorio;
    private final ResultadoFinalRepositorio resultadoFinalRepositorio;

    public RelatorioExecucaoCenarioRepositorio(
            CenarioRepositorio cenarioRepositorio,
            EntradaRepositorio entradaRepositorio,
            TesteRepositorio testeRepositorio,
            SaidaRepositorio saidaRepositorio,
            ResultadoFinalRepositorio resultadoFinalRepositorio) {
        this.cenarioRepositorio = cenarioRepositorio;
        this.entradaRepositorio = entradaRepositorio;
        this.testeRepositorio = testeRepositorio;
        this.saidaRepositorio = saidaRepositorio;
        this.resultadoFinalRepositorio = resultadoFinalRepositorio;
    }

    public RelatorioExecucaoCenarioDto gerar(Long idCenario) {
        return cenarioRepositorio.findById(idCenario).map(cenario -> {
            var relatorioExecucaoCenarioDto = new RelatorioExecucaoCenarioDto();
            relatorioExecucaoCenarioDto.setCenario(cenario.getTitulo());
            relatorioExecucaoCenarioDto.setDescricao(cenario.getDescricao());

            var resultadoFinal = resultadoFinalRepositorio.findByIdCenario(idCenario);
            resultadoFinal.ifPresent(r -> relatorioExecucaoCenarioDto.setResultadoFinal(r.getComentario()));

            var testes = testeRepositorio.findByIdCenario(idCenario);
            var testeDtos = testes.stream().map(teste -> {
                var testeDto = new TesteDto();
                testeDto.setDescricao(teste.getDescricao());
                testeDto.setTitulo(teste.getTitulo());

                var entradas = entradaRepositorio.findByIdTeste(teste.getId());
                var entradaSaidaDtos = entradas.stream().map(e -> {
                    var entradaSaidaDto = new EntradaSaidaDto();
                    entradaSaidaDto.setEntradaConteudo(e.getConteudo());
                    var saida = saidaRepositorio.findByIdEntrada(e.getId());
                    saida.ifPresent(s -> entradaSaidaDto.setSaidaConteudo(s.getConteudo()));
                    return entradaSaidaDto;
                }).toList();

                testeDto.setEntradaSaidaDtos(entradaSaidaDtos);
                return testeDto;
            }).toList();

            relatorioExecucaoCenarioDto.setTesteDtos(testeDtos);
            return relatorioExecucaoCenarioDto;
        }).orElseThrow(() -> new RecursoNotFoundException(idCenario, "Cenario"));
    }
}
