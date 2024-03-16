package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;

import java.util.List;

public class BuscarTodosHospedeUseCase {
    private final HospedeGateway hospedeGateway;

    public BuscarTodosHospedeUseCase(HospedeGateway hospedeGateway) {
        this.hospedeGateway = hospedeGateway;
    }

    public List<Hospede> execute() {
        return this.hospedeGateway.listar();
    }
}
