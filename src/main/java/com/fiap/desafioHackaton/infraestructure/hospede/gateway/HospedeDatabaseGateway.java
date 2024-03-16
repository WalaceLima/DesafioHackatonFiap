package com.fiap.desafioHackaton.infraestructure.hospede.gateway;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.infraestructure.hospede.entityschema.ClienteEntity;
import com.fiap.desafioHackaton.infraestructure.hospede.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HospedeDatabaseGateway implements HospedeGateway {

    private final ClienteRepository repository;

    public HospedeDatabaseGateway(ClienteRepository repository) {
        this.repository = repository;
    }


    @Override
    public Hospede criar(Hospede hospede) {
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        return repository.save(clienteEntity).toCliente();
    }


    @Override
    public Hospede atualizar(Hospede hospede) {
        if (hospede.getId() == null) {
            throw new IllegalArgumentException("Cliente ID não pode ser nulo ao atualizar");
        }
        Optional<ClienteEntity> optionalClienteEntity = repository.findById(hospede.getId());
        if (optionalClienteEntity.isEmpty()) {
            throw new IllegalArgumentException("Cliente com ID " + hospede.getId() + " não encontrado");
        }
        ClienteEntity encontrado = optionalClienteEntity.get();
        encontrado.setNome(hospede.getNome());
        encontrado.setCpf(hospede.getCpf());
        encontrado.setEmail(hospede.getEmail());
        encontrado.setDataNascimento(hospede.getDataNascimento());
        encontrado.setPassaporte(hospede.getPassaporte());
        encontrado.setPaisOrigem(hospede.getPaisOrigem());
        encontrado.setTelefone(hospede.getTelefone());
        encontrado.setEnderecoPaisOrigem(hospede.getEnderecoPaisOrigem());
        return repository.save(encontrado).toCliente();
    }

    @Override
    public List<Hospede> listar() {
        return repository.findAll().stream().map(ClienteEntity::toCliente).collect(Collectors.toList());
    }

    @Override
    public Optional<Hospede> buscarPorId(Long id) {
        return repository.findById(id).map(ClienteEntity::toCliente);
    }

    @Override
    public Optional<Hospede> buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).map(ClienteEntity::toCliente);
    }

    @Override
    public void deletar(Hospede hospede) {
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        repository.delete(clienteEntity);
    }


}
