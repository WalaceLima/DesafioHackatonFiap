package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;

import java.util.ArrayList;
import java.util.List;

public class BuscarQuartoPorQuantidadeDeHospedesUseCase {

    private final QuartoGateway quartoGateway;

    private final TipoQuartoGateway tipoQuartoGateway;

    public BuscarQuartoPorQuantidadeDeHospedesUseCase(QuartoGateway quartoGateway, TipoQuartoGateway tipoQuartoGateway) {
        this.quartoGateway = quartoGateway;
        this.tipoQuartoGateway = tipoQuartoGateway;
    }

    public List<Quarto> execute(Long numeroHospedes) {

        //encontrar todos os tipos de quarto que comportam a quantidade de hospedes
        List<TipoQuarto> tiposQuartosEncontrados = this.tipoQuartoGateway.buscaTiposQuartoPorCapacidadeTotal(numeroHospedes);

        //listar todos os quartos que pertencem aos tipos de quarto encontrados
        List<Quarto> quartosEncontrados = new ArrayList<>();
        for (TipoQuarto tipoQuarto : tiposQuartosEncontrados) {
            List<Quarto> quartosPorTipo = this.quartoGateway.buscarQuartoPorTipo(tipoQuarto);
            quartosEncontrados.addAll(quartosPorTipo);
        }
        return quartosEncontrados;
    }
}
