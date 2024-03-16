package com.fiap.desafioHackaton.infraestructure.hospede.repository;

import com.fiap.desafioHackaton.infraestructure.hospede.entityschema.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByCpf(String cpf);
}
