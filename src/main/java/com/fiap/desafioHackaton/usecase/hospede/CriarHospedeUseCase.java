package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfJaCadastradoException;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.exception.PassaporteObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedeRequestData;

import static com.fiap.desafioHackaton.usecase.hospede.utils.ClienteUtils.*;

public class CriarHospedeUseCase {

    private final HospedeGateway hospedeGateway;


    public CriarHospedeUseCase(HospedeGateway hospedeGateway) {
        this.hospedeGateway = hospedeGateway;
    }

    public Hospede executar(IHospedeRequestData dados) {

        if (eBrasileiro(dados.paisOrigem()) && cpfNaoInformado(dados.cpf()))
            throw new CpfObrigatorioException();

        if (!eBrasileiro(dados.paisOrigem()) && passaporteNaoInformado(dados.passaporte()))
            throw new PassaporteObrigatorioException();

        if (dados.cpf() != null && cpfCadastrado(dados.cpf())) {
            throw new CpfJaCadastradoException();
        }

        Hospede hospede = new Hospede(
                dados.paisOrigem(), dados.cpf(), dados.passaporte(),
                dados.nome(), dados.dataNascimento(),
                dados.enderecoPaisOrigem(), dados.telefone(), dados.email());

        return this.hospedeGateway.criar(hospede);

    }

    private boolean cpfCadastrado(String cpf) {
        return this.hospedeGateway.buscarPorCpf(cpf).isPresent();
    }
}
