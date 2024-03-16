package com.fiap.desafioHackaton.usecase.predio.dto;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;

import java.util.List;

public interface IPredioPublicData {

    Hotel hotel();

    Long id();

    String nome();

    List<Quarto> quartos();

}
