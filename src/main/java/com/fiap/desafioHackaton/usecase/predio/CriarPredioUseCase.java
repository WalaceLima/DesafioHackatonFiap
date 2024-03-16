package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;

public class CriarPredioUseCase {

    private final PredioGateway predioGateway;


    public CriarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public Predio executar(Predio predio) {

        return this.predioGateway.criar(predio);
    }

}
