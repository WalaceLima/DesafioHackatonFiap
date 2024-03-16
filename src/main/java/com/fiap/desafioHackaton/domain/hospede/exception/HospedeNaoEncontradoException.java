package com.fiap.desafioHackaton.domain.hospede.exception;

public class HospedeNaoEncontradoException extends RuntimeException {
    public HospedeNaoEncontradoException() {
        super("Cliente não encontrado");
    }
}
