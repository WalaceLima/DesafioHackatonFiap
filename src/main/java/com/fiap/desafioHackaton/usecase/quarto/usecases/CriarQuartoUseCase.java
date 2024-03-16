package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.desafioHackaton.usecase.quarto.dto.IQuartoRequestData;

public class CriarQuartoUseCase {

    private QuartoGateway quartoGateway;
    private PredioGateway predioGateway;

    private TipoQuartoGateway tipoQuartoGateway;

    public CriarQuartoUseCase(
            QuartoGateway quartoGateway,
            PredioGateway predioGateway,
            TipoQuartoGateway tipoQuartoGateway) {
        this.quartoGateway = quartoGateway;
        this.predioGateway = predioGateway;
        this.tipoQuartoGateway = tipoQuartoGateway;
    }

    public Quarto executar(IQuartoRequestData dados) {

        Predio predio = predioGateway.buscarPorId(dados.idPredio()).orElseThrow();
        TipoQuarto tipoQuarto = tipoQuartoGateway.buscarPorId(dados.idTipoQuarto());
        Status status = Status.valueOf(dados.status());

        Quarto quarto = new Quarto(
                predio,
                tipoQuarto,
                status,
                dados.valorDiaria()
        );
        return this.quartoGateway.criar(quarto);
    }
}
