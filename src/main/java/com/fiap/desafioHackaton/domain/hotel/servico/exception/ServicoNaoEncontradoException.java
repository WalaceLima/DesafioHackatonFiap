package com.fiap.desafioHackaton.domain.hotel.servico.exception;

public class ServicoNaoEncontradoException extends RuntimeException {
    public ServicoNaoEncontradoException() {
        super("Servico não encontrado");
    }
}
