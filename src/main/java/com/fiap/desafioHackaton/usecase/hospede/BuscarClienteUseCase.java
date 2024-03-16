package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;

public class BuscarClienteUseCase {

    private final HospedeGateway hospedeGateway;

    public BuscarClienteUseCase(HospedeGateway hospedeGateway) {
        this.hospedeGateway = hospedeGateway;
    }

    public Hospede execute(Long id) {
        return this.hospedeGateway.buscarPorId(id).orElseThrow();
    }


}
