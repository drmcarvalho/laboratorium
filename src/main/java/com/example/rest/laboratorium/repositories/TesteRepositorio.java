package com.example.rest.laboratorium.repositories;

import com.example.rest.laboratorium.models.Teste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TesteRepositorio extends JpaRepository<Teste, Long> {
    List<Teste> findByIdCenario(Long idCenario);
}
