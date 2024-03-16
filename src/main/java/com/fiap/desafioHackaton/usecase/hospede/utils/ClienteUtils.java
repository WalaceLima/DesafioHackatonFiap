package com.fiap.desafioHackaton.usecase.hospede.utils;

public class ClienteUtils {

    public static boolean passaporteNaoInformado(String passaporte) {
        return passaporte == null || passaporte.isBlank() || passaporte.isEmpty();
    }

    public static boolean cpfNaoInformado(String cpf) {
        return cpf == null || cpf.isBlank() || cpf.isEmpty();
    }

    public static boolean eBrasileiro(String pais) {
        String paisOrigem = pais.toLowerCase();
        return (paisOrigem.startsWith("br") || paisOrigem.equalsIgnoreCase("brasil"));
    }
}
