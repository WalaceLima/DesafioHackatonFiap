package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;

public class DeletarHospedeUseCase {

    private final HospedeGateway hospedeGateway;

    private final ReservaGateway reservaGateway;
    public DeletarHospedeUseCase(HospedeGateway hospedeGateway, ReservaGateway reservaGateway) {
        this.hospedeGateway = hospedeGateway;
        this.reservaGateway = reservaGateway;
    }

    public void execute(Long id) {
        Hospede hospede = this.hospedeGateway.buscarPorId(id).orElseThrow();
        this.reservaGateway.removerClienteDeReserva(hospede);
        this.hospedeGateway.deletar(hospede);
    }


}
