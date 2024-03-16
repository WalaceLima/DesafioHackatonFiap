package com.fiap.desafioHackaton.domain.hospede.exception;

public class PassaporteObrigatorioException extends RuntimeException {
    public PassaporteObrigatorioException() {
        super("Passaporte deve ser informado para estrangeiros");
    }
}
