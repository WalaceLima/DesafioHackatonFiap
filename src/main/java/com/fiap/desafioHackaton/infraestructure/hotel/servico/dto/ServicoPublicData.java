package com.fiap.desafioHackaton.infraestructure.hotel.servico.dto;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.usecase.servico.dto.IServicoPublicData;

import java.math.BigDecimal;

public record ServicoPublicData(
        Long id,
        String nome,
        BigDecimal valor
) implements IServicoPublicData {

    public ServicoPublicData(Servico servico) {
        this(
                servico.getId(),
                servico.getNome(),
                servico.getValor()
        );
    }
}