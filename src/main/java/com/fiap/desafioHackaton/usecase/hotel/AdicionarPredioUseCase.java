package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.usecase.predio.CriarPredioUseCase;
import com.fiap.desafioHackaton.usecase.predio.dto.IPredioRequestData;

public class AdicionarPredioUseCase {

    private final HotelGateway hotelGateway;
    private final CriarPredioUseCase criarPredioUseCase;

    public AdicionarPredioUseCase(HotelGateway hotelGateway, CriarPredioUseCase criarPredioUseCase) {
        this.hotelGateway = hotelGateway;
        this.criarPredioUseCase = criarPredioUseCase;
    }

    public Hotel executar(Long hotelId, IPredioRequestData dados) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();

        Predio predio = new Predio(
                dados.nome(),
                hotel
        );

        Predio predioSalvo = this.criarPredioUseCase.executar(predio);
        hotel.addPredio(predioSalvo);

        return this.hotelGateway.adicionarPredio(hotel);
    }

}
