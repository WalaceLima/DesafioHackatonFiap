package com.fiap.desafioHackaton.infraestructure.hotel.item.dto;

import com.fiap.desafioHackaton.usecase.item.dto.IItemRequestData;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ItemRequestData(

        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Digits(integer = 6, fraction = 2, message = "Valor inválido")
        @Positive(message = "Valor deve ser maior que zero")
        BigDecimal valor

) implements IItemRequestData {
}