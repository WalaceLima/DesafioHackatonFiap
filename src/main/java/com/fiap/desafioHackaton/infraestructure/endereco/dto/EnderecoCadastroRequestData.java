package com.fiap.desafioHackaton.infraestructure.endereco.dto;

public record EnderecoCadastroRequestData(
        String logradouro,
        String cep,
        String cidade,
        String estado
) {
}
