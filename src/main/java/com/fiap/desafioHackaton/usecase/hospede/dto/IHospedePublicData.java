package com.fiap.desafioHackaton.usecase.hospede.dto;

import java.time.LocalDate;

public interface IHospedePublicData {

    Long id();

    String paisOrigem();

    String cpf();

    String passaporte();

    String nome();

    LocalDate dataNascimento();

    String enderecoPaisOrigem();

    String telefone();

    String email();

}
