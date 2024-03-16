package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import com.fiap.desafioHackaton.usecase.quarto.dto.IQuartoRequestData;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;

public record QuartoRequestData(

        @Min(value = 1, message = "Id do predio deve ser informado")
        Long idPredio,
        @Min(value = 1, message = "Id do tipo quarto deve ser informado")
        Long idTipoQuarto,
        String status,
        @DecimalMin(value = "0.0", inclusive = false)
        @Digits(integer = 6, fraction = 2)
        BigDecimal valorDiaria

) implements IQuartoRequestData {
}
