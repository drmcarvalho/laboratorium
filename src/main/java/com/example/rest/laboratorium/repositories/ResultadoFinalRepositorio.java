package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.models.ResultadoFinal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultadoFinalRepositorio extends JpaRepository<ResultadoFinal, Long> {

    boolean existsByIdCenario(Long idCenario);

    Optional<ResultadoFinal> findByIdCenario(Long idCenario);
}
