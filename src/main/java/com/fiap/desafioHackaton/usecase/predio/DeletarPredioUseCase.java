package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;

public class DeletarPredioUseCase {

    private final PredioGateway predioGateway;

    public DeletarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public void executar(Long id) {
        Predio predio = this.predioGateway.buscarPorId(id).orElseThrow();
        this.predioGateway.deletar(predio);
    }

}
