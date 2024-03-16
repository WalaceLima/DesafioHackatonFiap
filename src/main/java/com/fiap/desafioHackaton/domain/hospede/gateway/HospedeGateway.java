package com.fiap.desafioHackaton.domain.hospede.gateway;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;

import java.util.List;
import java.util.Optional;

public interface HospedeGateway {


    Hospede criar(Hospede hospede);

    Hospede atualizar(Hospede hospede);

    List<Hospede> listar();

    Optional<Hospede> buscarPorId(Long id);

    Optional<Hospede> buscarPorCpf(String cpf);

    void deletar(Hospede hospede);

}
