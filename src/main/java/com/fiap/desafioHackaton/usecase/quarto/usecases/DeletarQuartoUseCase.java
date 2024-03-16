package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.usecase.reserva.RemoverQuartoDeReservasUseCase;

public class DeletarQuartoUseCase {

    private final QuartoGateway quartoGateway;

    private final RemoverQuartoDeReservasUseCase removerQuartoDeReservasUseCase;

    public DeletarQuartoUseCase(QuartoGateway quartoGateway, RemoverQuartoDeReservasUseCase removerQuartoDeReservasUseCase) {
        this.quartoGateway = quartoGateway;
        this.removerQuartoDeReservasUseCase = removerQuartoDeReservasUseCase;
    }

    public void executar(Long id) {
        Quarto quarto = this.quartoGateway.buscarPorId(id).orElseThrow();
        removerQuartoDeReservasUseCase.executar(quarto);
        this.quartoGateway.deletar(quarto);
    }
}
