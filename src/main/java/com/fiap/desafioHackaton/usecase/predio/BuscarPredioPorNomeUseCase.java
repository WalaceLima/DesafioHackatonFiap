package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.exception.PredioNaoEncontradoException;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;

import java.util.List;
import java.util.Optional;

public class BuscarPredioPorNomeUseCase {
    private final PredioGateway predioGateway;

    public BuscarPredioPorNomeUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public List<Predio> execute (String nome) {
        Optional<List<Predio>> predios = this.predioGateway.buscarPorNome(nome);
        if (predios.isEmpty()) {
            throw new PredioNaoEncontradoException();
        }

        return predios.get();
    }


}
