package com.fiap.desafioHackaton.domain.predio.exception;

public class PredioNaoEncontradoException extends RuntimeException{
    public PredioNaoEncontradoException(){
        super("Predio não encontrado");
    }
}
