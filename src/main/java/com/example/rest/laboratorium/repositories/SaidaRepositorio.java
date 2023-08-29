package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.models.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaidaRepositorio extends JpaRepository<Saida, Long> {
    boolean existsByIdEntrada(Long idEntrada);
    Optional<Saida> findByIdEntrada(Long idEntrada);
}
