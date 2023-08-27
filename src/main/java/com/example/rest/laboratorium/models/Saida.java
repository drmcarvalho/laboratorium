package com.example.rest.laboratorium.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Saida {
    private @Id @GeneratedValue Long id;
    private Long idEntrada;
    private String conteudo;
    private String comentario;

    public Saida(Long idEntrada, String conteudo, String comentario) {
        this.idEntrada = idEntrada;
        this.conteudo = conteudo;
        this.comentario = comentario;
    }

    public Saida() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Long idEntrada) {
        this.idEntrada = idEntrada;
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

    @Override
    public String toString() {
        return "Saida{" +
                "id=" + id +
                ", idEntrada=" + idEntrada +
                ", conteudo='" + conteudo + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
