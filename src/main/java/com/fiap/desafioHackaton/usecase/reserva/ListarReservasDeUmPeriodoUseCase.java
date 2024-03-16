package com.fiap.desafioHackaton.usecase.reserva;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;

import java.time.LocalDate;
import java.util.List;

public class ListarReservasDeUmPeriodoUseCase {

    private final ReservaGateway reservaGateway;

    public ListarReservasDeUmPeriodoUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public List<Reserva> executar(LocalDate inicio, LocalDate fim) {
        return reservaGateway.listarPorPeriodo(inicio, fim);
    }
}
