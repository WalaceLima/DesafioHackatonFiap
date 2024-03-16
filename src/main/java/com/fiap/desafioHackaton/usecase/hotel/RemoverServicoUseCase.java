package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.usecase.servico.BuscarServicoUseCase;

public class RemoverServicoUseCase {

    private final HotelGateway hotelGateway;
    private final BuscarServicoUseCase buscarServicoUseCase;

    public RemoverServicoUseCase(HotelGateway hotelGateway, BuscarServicoUseCase buscarServicoUseCase) {
        this.hotelGateway = hotelGateway;
        this.buscarServicoUseCase = buscarServicoUseCase;
    }


    public Hotel executar(Long hotelId, Long servicoId) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();
        Servico servico = buscarServicoUseCase.execute(servicoId);


        hotel.removerServico(servico);

        return hotelGateway.removerServico(hotel);


    }
}
