package com.example.rest.laboratorium.dtos;

import com.example.rest.laboratorium.models.*;

import java.util.Collection;

public class RelatorioExecucaoTesteDTO {

    private Cenario cenario;
    private Collection<Teste> testes;
    private Collection<Entrada> entradas;
    private Collection<Saida> saidas;
    private ResultadoFinal resultadoFinal;

    public Cenario getCenario() {
        return cenario;
    }

    public void setCenario(Cenario cenario) {
        this.cenario = cenario;
    }

    public Collection<Teste> getTestes() {
        return testes;
    }

    public void setTestes(Collection<Teste> testes) {
        this.testes = testes;
    }

    public Collection<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(Collection<Entrada> entradas) {
        this.entradas = entradas;
    }

    public Collection<Saida> getSaidas() {
        return saidas;
    }

    public void setSaidas(Collection<Saida> saidas) {
        this.saidas = saidas;
    }

    public ResultadoFinal getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(ResultadoFinal resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }
}
