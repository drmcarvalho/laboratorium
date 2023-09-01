package com.example.rest.laboratorium.dtos.relatorio;

public class EntradaSaidaDto {

    private String entradaConteudo;
    private String saidaConteudo;

    public EntradaSaidaDto(String entradaConteudo, String saidaConteudo) {
        this.entradaConteudo = entradaConteudo;
        this.saidaConteudo = saidaConteudo;
    }

    public EntradaSaidaDto(){}

    public String getEntradaConteudo() {
        return entradaConteudo;
    }

    public void setEntradaConteudo(String entradaConteudo) {
        this.entradaConteudo = entradaConteudo;
    }

    public String getSaidaConteudo() {
        return saidaConteudo;
    }

    public void setSaidaConteudo(String saidaConteudo) {
        this.saidaConteudo = saidaConteudo;
    }
}
