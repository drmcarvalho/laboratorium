package com.example.rest.laboratorium.dtos.relatorio;

public class EntradaDto {

    private String conteudo;
    private SaidaDto saidaDto;

    public EntradaDto(String conteudo, SaidaDto saidaDto) {
        this.conteudo = conteudo;
        this.saidaDto = saidaDto;
    }

    public EntradaDto(){ }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public SaidaDto getSaidaDto() {
        return saidaDto;
    }

    public void setSaidaDto(SaidaDto saidaDto) {
        this.saidaDto = saidaDto;
    }
}
