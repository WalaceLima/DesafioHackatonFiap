package com.fiap.desafioHackaton.usecase.reserva;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.desafioHackaton.infraestructure.quarto.entitySchema.QuartoEntity;

public class RemoverQuartoDeReservasUseCase {

    private final ReservaGateway reservaGateway;

    public RemoverQuartoDeReservasUseCase(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    public void executar(Quarto quarto) {
        this.reservaGateway.removerQuartoDeReservas(new QuartoEntity(quarto));
    }
}
