package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.desafioHackaton.usecase.servico.dto.IServicoRequestData;

public class CriarServicoUseCase {

    private final ServicoGateway servicoGateway;

    public CriarServicoUseCase(ServicoGateway servicoGateway) {
        this.servicoGateway = servicoGateway;
    }

    public Servico executar(IServicoRequestData dados) {

        Servico servico = new Servico(
                dados.nome(), dados.valor());

        return this.servicoGateway.criar(servico);
    }
}