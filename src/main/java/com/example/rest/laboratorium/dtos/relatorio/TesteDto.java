package com.example.rest.laboratorium.dtos.relatorio;

import java.util.List;

public class TesteDto {

    private String descricao;
    private String titulo;
    private List<EntradaDto> entradaDtos;

    public TesteDto(String descricao, String titulo, List<EntradaDto> entradaDtos) {
        this.descricao = descricao;
        this.titulo = titulo;
        this.entradaDtos = entradaDtos;
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

    public List<EntradaDto> getEntradaDtos() {
        return entradaDtos;
    }

    public void setEntradaDtos(List<EntradaDto> entradaDtos) {
        this.entradaDtos = entradaDtos;
    }
}
