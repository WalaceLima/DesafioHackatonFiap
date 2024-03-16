package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.exception.PassaporteObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedeRequestData;

import static com.fiap.desafioHackaton.usecase.hospede.utils.ClienteUtils.*;

public class AtualizarHospedeeUseCase {

    private final HospedeGateway hospedeGateway;

    public AtualizarHospedeeUseCase(HospedeGateway hospedeGateway) {
        this.hospedeGateway = hospedeGateway;
    }

    public Hospede execute(Long id, IHospedeRequestData dados) {

        Hospede hospede = this.hospedeGateway.buscarPorId(id).orElseThrow();

        if (eBrasileiro(dados.paisOrigem()) && cpfNaoInformado(dados.cpf()))
            throw new CpfObrigatorioException();

        if (!eBrasileiro(dados.paisOrigem()) && passaporteNaoInformado(dados.passaporte()))
            throw new PassaporteObrigatorioException();

        Hospede hospedeAtualizado = this.atualizarCliente(hospede, dados);

        return this.hospedeGateway.atualizar(hospedeAtualizado);
    }


    private Hospede atualizarCliente(Hospede hospede, IHospedeRequestData dados) {
        hospede.setCpf(dados.cpf());
        hospede.setNome(dados.nome());
        hospede.setEmail(dados.email());
        hospede.setDataNascimento(dados.dataNascimento());
        hospede.setPaisOrigem(dados.paisOrigem());
        hospede.setPassaporte(dados.passaporte());

        return hospede;
    }


}
