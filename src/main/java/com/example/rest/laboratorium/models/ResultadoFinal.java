package com.example.rest.laboratorium.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ResultadoFinal {

    private @Id @GeneratedValue Long id;

    private Long idCenario;
    private String comentario;

    public ResultadoFinal(String comentario, Long idCenario) {
        this.comentario = comentario;
        this.idCenario = idCenario;
    }

    public ResultadoFinal(){}

    public Long getId() {
        return id;
    }

    public Long getIdCenario() {
        return idCenario;
    }

    public void setIdCenario(Long idCenario) {
        this.idCenario = idCenario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "ResultadoFinal{" +
                "id=" + id +
                ", idCenario=" + idCenario +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
