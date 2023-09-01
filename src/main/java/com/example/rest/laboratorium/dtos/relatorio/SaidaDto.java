package com.example.rest.laboratorium.dtos.relatorio;

public class SaidaDto {

    private String conteudo;
    private String comentario;

    public SaidaDto(){}

    public SaidaDto(String conteudo, String comentario) {
        this.conteudo = conteudo;
        this.comentario = comentario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
