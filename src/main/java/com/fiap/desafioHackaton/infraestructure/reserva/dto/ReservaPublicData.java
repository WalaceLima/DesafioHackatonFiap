package com.fiap.desafioHackaton.infraestructure.reserva.dto;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.usecase.reserva.dto.IReservaPublicData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record ReservaPublicData(
        Long id,
        LocalDate dataInicial,
        LocalDate dataFinal,
        BigDecimal valorReserva,
        BigDecimal valorTotal,
        Integer quantidadePessoas,
        Hospede responsavelReserva,
        List<Quarto> quartosReservados,
        List<Item> itensConsumidos,
        List<Servico> servicosConsumidos

) implements IReservaPublicData {
    public ReservaPublicData(Reserva reserva) {
        this(
                reserva.getId(),
                reserva.getDataInicial(),
                reserva.getDataFinal(),
                reserva.getValorReserva(),
                reserva.getValorTotal(),
                reserva.getQuantidadePessoas(),
                reserva.getResponsavelReserva(),
                reserva.getQuartosReservados(),
                reserva.getItensConsumidos(),
                reserva.getServicosConsumidos()
        );
    }
}
