package com.fiap.desafioHackaton.usecase.reserva;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;

public class DeletarReservaPorIdUseCase {

    private final ReservaGateway reservaGateway;

    public DeletarReservaPorIdUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public void executar(Long id) {
        Reserva reserva = this.reservaGateway.buscarPorId(id).orElseThrow();
        this.reservaGateway.deletar(reserva);
    }

}
