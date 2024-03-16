package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import com.fiap.desafioHackaton.usecase.predio.dto.IPredioUpdateData;

public class AtualizarPredioUseCase {
    private final PredioGateway predioGateway;

    public AtualizarPredioUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }


    public Predio executar(Long id, IPredioUpdateData dados) {

        Predio predio = this.predioGateway.buscarPorId(id).orElseThrow();
        predio.setNome(dados.nome());

        return this.predioGateway.atualizar(predio);

    }
}
