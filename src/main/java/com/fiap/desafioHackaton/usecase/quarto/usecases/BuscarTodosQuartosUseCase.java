package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;

import java.util.List;

public class BuscarTodosQuartosUseCase {

    private final QuartoGateway quartoGateway;

    public BuscarTodosQuartosUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public List<Quarto> execute() {
        return this.quartoGateway.listar();
    }
}
