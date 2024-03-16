package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.exception.PredioNaoEncontradoException;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public class BuscarTodosPrediosUseCase {

    private final PredioGateway predioGateway;

    public BuscarTodosPrediosUseCase(PredioGateway predioGateway) {
        this.predioGateway = predioGateway;
    }

    public List<Predio> executar() {
        List<Predio> predios = this.predioGateway.listar();
        if (predios.isEmpty()) {
            throw new PredioNaoEncontradoException();
        }

        return predios;
    }

}
