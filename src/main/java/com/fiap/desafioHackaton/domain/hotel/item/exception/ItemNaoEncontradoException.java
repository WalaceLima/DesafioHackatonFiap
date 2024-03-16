package com.fiap.desafioHackaton.domain.hotel.item.exception;

public class ItemNaoEncontradoException extends RuntimeException {
    public ItemNaoEncontradoException() {
        super("Item não encontrado");
    }
}
