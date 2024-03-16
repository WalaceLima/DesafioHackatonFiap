package com.fiap.desafioHackaton.infraestructure.hospede.dto;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedePublicData;

import java.time.LocalDate;

public record HospedePublicData(
        Long id,
        String paisOrigem,
        String cpf,
        String passaporte,
        String nome,
        LocalDate dataNascimento,
        String enderecoPaisOrigem,
        String telefone,
        String email
) implements IHospedePublicData {

    public HospedePublicData(Hospede hospede) {
        this(
                hospede.getId(),
                hospede.getPaisOrigem(),
                hospede.getCpf(),
                hospede.getPassaporte(),
                hospede.getNome(),
                hospede.getDataNascimento(),
                hospede.getEnderecoPaisOrigem(),
                hospede.getTelefone(),
                hospede.getEmail()
        );
    }
}
