package com.fiap.desafioHackaton.usecase.reserva.dto;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IReservaPublicData {
    Long id();
    LocalDate dataInicial();
    LocalDate dataFinal();
    BigDecimal valorReserva();
    BigDecimal valorTotal();
    Integer quantidadePessoas();
    Hospede responsavelReserva();
    List<Quarto> quartosReservados();
    List<Item> itensConsumidos();
    List<Servico> servicosConsumidos();
}
