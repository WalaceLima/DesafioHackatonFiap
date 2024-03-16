package com.fiap.desafioHackaton.usecase.item.utils;

public class ItemUtils {

    public static boolean nomeNaoInformado(String nome) {
        return nome == null || nome.isBlank();
    }

    public static boolean valorNaoInformado(Double valor) {
        return valor == null || valor.isNaN();
    }
}
