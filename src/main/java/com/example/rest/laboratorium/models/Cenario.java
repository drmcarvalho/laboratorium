package com.example.rest.laboratorium.models;

import com.example.rest.laboratorium.models.enums.CenarioSituacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;
import org.springframework.lang.NonNullFields;

import java.util.Objects;

@Entity
public class Cenario {
    private @Id @GeneratedValue Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Cenario{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", cenarioSituacao=" + cenarioSituacao +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Cenario cenario))
            return false;
        return Objects.equals(this.id, cenario.id) &&
                Objects.equals(this.titulo, cenario.titulo) &&
                Objects.equals(this.descricao, cenario.descricao) &&
                Objects.equals(this.cenarioSituacao, cenario.cenarioSituacao);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CenarioSituacao getSituacao() {
        return cenarioSituacao;
    }

    public void setSituacao(CenarioSituacao cenarioSituacao) {
        this.cenarioSituacao = cenarioSituacao;
    }
    private String titulo;
    private String descricao;
    private CenarioSituacao cenarioSituacao = CenarioSituacao.EM_ANALISE;

    Cenario() { }

    Cenario(String titulo, String descricao, CenarioSituacao cenarioSituacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.cenarioSituacao = cenarioSituacao;
    }
}
