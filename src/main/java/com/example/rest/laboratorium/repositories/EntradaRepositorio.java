package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.models.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntradaRepositorio extends JpaRepository<Entrada, Long> {
    List<Entrada> findByIdTeste(Long idTeste);
}
