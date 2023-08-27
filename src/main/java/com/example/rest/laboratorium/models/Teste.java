package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.models.enums.TesteSituacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Teste {
    private @Id @GeneratedValue Long id;
    private Long idCenario;
    private String descricao;
    private String titulo;
    private TesteSituacao testeSituacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCenario() {
        return idCenario;
    }

    public void setIdCenario(Long idCenario) {
        this.idCenario = idCenario;
    }

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

    public TesteSituacao getTesteSituacao() {
        return testeSituacao;
    }

    public void setTesteSituacao(TesteSituacao testeSituacao) {
        this.testeSituacao = testeSituacao;
    }

    public Teste() { }

    public Teste(Long idCenario, String descricao, String titulo, TesteSituacao testeSituacao) {
        this.idCenario = idCenario;
        this.descricao = descricao;
        this.titulo = titulo;
        this.testeSituacao = testeSituacao;
    }

    @Override
    public String toString() {
        return "Teste{" +
                "id=" + id +
                ", idCenario=" + idCenario +
                ", descricao='" + descricao + '\'' +
                ", titulo='" + titulo + '\'' +
                ", testeSituacao=" + testeSituacao +
                '}';
    }
}
