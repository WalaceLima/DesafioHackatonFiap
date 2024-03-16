package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;

import java.time.LocalDate;
import java.util.List;

public class ListarQuartosPorPeriodoDisponibilidadeUseCase {

    private final QuartoGateway quartoGateway;

    public ListarQuartosPorPeriodoDisponibilidadeUseCase(QuartoGateway quartoGateway) {
        this.quartoGateway = quartoGateway;
    }

    public List<Quarto> execute (LocalDate dataInicio, LocalDate dataFim, Status status){
        List<Quarto> quartosDisponiveis = this.quartoGateway.listarQuartoPorPeriodoDisponibilidade(dataInicio, dataFim, status);
        return quartosDisponiveis;
    }

}
