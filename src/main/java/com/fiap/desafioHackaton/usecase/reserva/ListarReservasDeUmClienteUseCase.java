package com.fiap.desafioHackaton.usecase.reserva;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasDeUmClienteUseCase {
    private final ReservaGateway reservaGateway;

    public ListarReservasDeUmClienteUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public List<Reserva> executar(String cpf) {
        return reservaGateway.listarPorCliente(cpf);
    }
}
