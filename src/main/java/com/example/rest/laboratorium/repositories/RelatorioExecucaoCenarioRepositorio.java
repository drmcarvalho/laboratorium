package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.controllers.controlleradvice.RecursoNotFoundException;
import com.example.rest.laboratorium.dtos.relatorio.EntradaSaidaDto;
import com.example.rest.laboratorium.dtos.relatorio.RelatorioExecucaoCenarioDto;
import com.example.rest.laboratorium.dtos.relatorio.TesteDto;
import com.example.rest.laboratorium.models.Entrada;
import com.example.rest.laboratorium.models.ResultadoFinal;
import com.example.rest.laboratorium.models.Saida;
import com.example.rest.laboratorium.models.Teste;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
            RelatorioExecucaoCenarioDto relatorioExecucaoCenarioDto = new RelatorioExecucaoCenarioDto();
            relatorioExecucaoCenarioDto.setCenario(cenario.getTitulo());
            relatorioExecucaoCenarioDto.setDescricao(cenario.getDescricao());

            Optional<ResultadoFinal> resultadoFinal = resultadoFinalRepositorio.findByIdCenario(idCenario);
            resultadoFinal.ifPresent(r -> relatorioExecucaoCenarioDto.setResultadoFinal(r.getComentario()));

            List<Teste> testes = testeRepositorio.findByIdCenario(idCenario);
            List<TesteDto> testeDtos = testes.stream().map(teste -> {
                TesteDto testeDto = new TesteDto();
                testeDto.setDescricao(teste.getDescricao());
                testeDto.setTitulo(teste.getTitulo());

                List<Entrada> entradas = entradaRepositorio.findByIdTeste(teste.getId());
                List<EntradaSaidaDto>  entradaSaidaDtos = entradas.stream().map(e -> {
                    EntradaSaidaDto entradaSaidaDto = new EntradaSaidaDto();
                    entradaSaidaDto.setEntradaConteudo(e.getConteudo());
                    Optional<Saida> saida = saidaRepositorio.findByIdEntrada(e.getId());
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
