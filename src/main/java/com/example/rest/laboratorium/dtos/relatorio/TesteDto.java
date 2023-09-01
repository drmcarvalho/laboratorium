package com.example.rest.laboratorium.dtos.relatorio;

import java.util.List;

public class TesteDto {

    private String descricao;
    private String titulo;
    private List<EntradaSaidaDto> entradaSaidaDtos;

    public TesteDto(String descricao, String titulo, List<EntradaSaidaDto> entradaSaidaDtos) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.entradaSaidaDtos = entradaSaidaDtos;
    }

    public TesteDto() { }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<EntradaSaidaDto> getEntradaSaidaDtos() {
        return entradaSaidaDtos;
    }

    public void setEntradaSaidaDtos(List<EntradaSaidaDto> entradaSaidaDtos) {
        this.entradaSaidaDtos = entradaSaidaDtos;
    }
}
