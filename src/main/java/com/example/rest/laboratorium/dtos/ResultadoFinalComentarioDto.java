package com.example.rest.laboratorium.dtos;

public class ResultadoFinalComentarioDto {

    private String comentario;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public ResultadoFinalComentarioDto() { }

    public ResultadoFinalComentarioDto(String comentario) {
        this.comentario = comentario;
    }
}
