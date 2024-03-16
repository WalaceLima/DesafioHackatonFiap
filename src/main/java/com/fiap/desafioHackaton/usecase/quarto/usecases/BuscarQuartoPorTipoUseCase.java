package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;

import java.util.List;

public class BuscarQuartoPorTipoUseCase {
    private final QuartoGateway quartoGateway;

    private final TipoQuartoGateway tipoQuartoGateway;

    public BuscarQuartoPorTipoUseCase(QuartoGateway quartoGateway, TipoQuartoGateway tipoQuartoGateway) {
        this.quartoGateway = quartoGateway;
        this.tipoQuartoGateway = tipoQuartoGateway;
    }

    public List<Quarto> execute(Long idTipoQuarto) {
        TipoQuarto tipoQuarto = tipoQuartoGateway.buscarPorId(idTipoQuarto);
        return this.quartoGateway.buscarQuartoPorTipo(tipoQuarto);
    }
}
