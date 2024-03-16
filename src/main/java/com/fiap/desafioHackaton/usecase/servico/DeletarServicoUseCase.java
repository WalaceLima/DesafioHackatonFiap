package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;

public class DeletarServicoUseCase {

    private final ServicoGateway servicoGateway;

    private final HotelGateway hotelGateway;
    public DeletarServicoUseCase(ServicoGateway servicoGateway, HotelGateway hotelGateway) {
        this.servicoGateway = servicoGateway;
        this.hotelGateway = hotelGateway;
    }

    public void execute(Long id) {
        Servico servico = this.servicoGateway.buscarPorId(id).orElseThrow();
        this.hotelGateway.removerRelacionamentoServico(servico);
        this.servicoGateway.deletar(servico);
    }
}
