package com.fiap.desafioHackaton.infraestructure.hotel.servico.dto;

import com.fiap.desafioHackaton.usecase.servico.dto.IServicoRequestData;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ServicoRequestData(


        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Digits(integer = 6, fraction = 2, message = "Valor inválido")
        @Positive(message = "Valor deve ser maior que zero")
        BigDecimal valor

) implements IServicoRequestData {
}
