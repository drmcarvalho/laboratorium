package com.example.rest.laboratorium.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Entrada {
    private @Id @GeneratedValue Long id;
    private Long idTeste;
    private String conteudo;

    public Entrada() { }

    public Entrada(Long idTeste, String conteudo) {
        this.idTeste = idTeste;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTeste() {
        return idTeste;
    }

    public void setIdTeste(Long idTeste) {
        this.idTeste = idTeste;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                ", idTeste=" + idTeste +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
