package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.models.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepositorio extends JpaRepository<Saida, Long> {
    boolean existsByIdEntrada(Long idEntrada);
}
