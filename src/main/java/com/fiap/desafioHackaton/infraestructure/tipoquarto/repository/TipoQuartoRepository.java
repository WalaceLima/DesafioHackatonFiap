package com.fiap.desafioHackaton.infraestructure.tipoquarto.repository;

import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoQuartoRepository extends JpaRepository<TipoQuartoEntity, Long> {
    List<TipoQuartoEntity> findByCapacidadeTotalGreaterThanEqual(Long capacidadeTotal);
}
