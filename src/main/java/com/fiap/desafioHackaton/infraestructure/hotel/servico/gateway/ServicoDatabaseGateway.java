package com.fiap.desafioHackaton.infraestructure.hotel.servico.gateway;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ServicoDatabaseGateway implements ServicoGateway {

    private final ServicoRepository repository;

    public ServicoDatabaseGateway(ServicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Servico criar(Servico servico) {
        ServicoEntity servicoEntity = new ServicoEntity(servico);
        return repository.save(servicoEntity).toEntity();
    }

    @Override
    public Servico atualizar(Servico servico) {
        if (servico.getId() == null) {
            throw new IllegalArgumentException("Servico ID não pode ser nulo ao atualizar");
        }
        Optional<ServicoEntity> optionalServicoEntity = repository.findById(servico.getId());
        if (optionalServicoEntity.isEmpty()) {
            throw new IllegalArgumentException("Servico com ID " + servico.getId() + " não encontrado");
        }
        ServicoEntity encontrado = optionalServicoEntity.get();
        encontrado.setNome(servico.getNome());
        encontrado.setValor(servico.getValor());
        return repository.save(encontrado).toEntity();
    }

    @Override
    public List<Servico> listar() {
        return repository.findAll().stream().map(ServicoEntity::toEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Servico> buscarPorId(Long id) {
        Optional<ServicoEntity> optionalServicoEntity = repository.findById(id);
        if (optionalServicoEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(optionalServicoEntity.get().toEntity());
    }

    @Override
    public void deletar(Servico servico) {
        ServicoEntity servicoEntity = new ServicoEntity(servico);
        repository.delete(servicoEntity);
    }
}