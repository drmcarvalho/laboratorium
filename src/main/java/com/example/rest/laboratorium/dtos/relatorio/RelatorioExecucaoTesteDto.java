package com.example.rest.laboratorium.dtos.relatorio;

import java.util.List;

public class RelatorioExecucaoTesteDto {

    private String cenario;
    private String descricao;
    private String resultadoFinal;
    private List<TesteDto> testeDtos;

    public RelatorioExecucaoTesteDto(String cenario, String descricao, String resultadoFinal, List<TesteDto> testeDtos) {
        this.cenario = cenario;
        this.descricao = descricao;
        this.resultadoFinal = resultadoFinal;
        this.testeDtos = testeDtos;
    }

    public RelatorioExecucaoTesteDto() { }

    public String getCenario() {
        return cenario;
    }

    public void setCenario(String cenario) {
        this.cenario = cenario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public List<TesteDto> getTesteDtos() {
        return testeDtos;
    }

    public void setTesteDtos(List<TesteDto> testeDtos) {
        this.testeDtos = testeDtos;
    }
}
