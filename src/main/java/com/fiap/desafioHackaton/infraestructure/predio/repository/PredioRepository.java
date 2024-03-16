package com.fiap.desafioHackaton.infraestructure.predio.repository;

import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PredioRepository extends JpaRepository<PredioEntity, Long> {
    Optional<List<PredioEntity>> findByNome(String nome);
}
