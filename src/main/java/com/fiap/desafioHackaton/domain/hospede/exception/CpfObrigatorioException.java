package com.fiap.desafioHackaton.domain.hospede.exception;

public class CpfObrigatorioException extends RuntimeException {
    public CpfObrigatorioException() {
        super("Cpf deve ser obrigatório para brasileiros");
    }
}
