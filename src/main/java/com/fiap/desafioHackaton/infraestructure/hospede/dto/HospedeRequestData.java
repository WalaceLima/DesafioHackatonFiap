package com.fiap.desafioHackaton.infraestructure.hospede.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedeRequestData;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record HospedeRequestData(

        @NotBlank(message = "Pais de origem é obrigatório")
        String paisOrigem,

        @Digits(integer = 11, fraction = 0, message = "CPF deve conter apenas números e ter no máximo 11 dígitos")
        String cpf,
        String passaporte,
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @Past(message = "Data de nascimento deve ser uma data no passado no formato yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate dataNascimento,
        @NotBlank(message = "Endereço do país de origem é obrigatório")
        String enderecoPaisOrigem,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @Email(message = "Email inválido")
        String email

) implements IHospedeRequestData {
}
