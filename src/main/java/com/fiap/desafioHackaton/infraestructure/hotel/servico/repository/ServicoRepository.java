package com.fiap.desafioHackaton.infraestructure.hotel.servico.repository;

import com.fiap.desafioHackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
}
