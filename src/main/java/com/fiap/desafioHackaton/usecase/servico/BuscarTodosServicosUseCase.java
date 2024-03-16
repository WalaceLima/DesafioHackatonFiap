package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.exception.ServicoNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;

import java.util.List;

public class BuscarTodosServicosUseCase {
    private final ServicoGateway servicoGateway;

    public BuscarTodosServicosUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public List<Servico> execute() {
        List<Servico> servicos = this.servicoGateway.listar();

        if (servicos.isEmpty()) {
            throw new ServicoNaoEncontradoException();
        }
        return servicos;
    }
}