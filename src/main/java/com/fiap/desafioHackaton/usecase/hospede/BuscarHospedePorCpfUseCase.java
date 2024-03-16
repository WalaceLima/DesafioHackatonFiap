package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;

public class BuscarHospedePorCpfUseCase {

    private final HospedeGateway hospedeGateway;

    public BuscarHospedePorCpfUseCase(HospedeGateway hospedeGateway) {
        this.hospedeGateway = hospedeGateway;
    }

    public Hospede execute(String cpf) {
        return this.hospedeGateway.buscarPorCpf(cpf).orElseThrow();
    }
}
