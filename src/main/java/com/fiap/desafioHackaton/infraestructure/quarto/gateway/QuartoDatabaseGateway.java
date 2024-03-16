package com.fiap.desafioHackaton.infraestructure.quarto.gateway;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartosDisponiveisDTO;
import com.fiap.desafioHackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.desafioHackaton.infraestructure.quarto.repository.QuartoRepository;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuartoDatabaseGateway implements QuartoGateway {

    private final QuartoRepository repository;

    public QuartoDatabaseGateway(QuartoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Quarto criar(Quarto quarto) {
        QuartoEntity quartoEntity = new QuartoEntity(quarto);
        return repository.save(quartoEntity).toEntity();
    }

    @Override
    public Quarto atualizar(Quarto quarto) {
        if (quarto.getId() == null) {
            throw new IllegalArgumentException("Quarto ID não pode ser nulo ao atualizar");
        }
        Optional<QuartoEntity> optionalQuartoEntity = repository.findById(quarto.getId());
        if (optionalQuartoEntity.isEmpty()) {
            throw new IllegalArgumentException("Quarto com ID " + quarto.getId() + " não encontrado");
        }
        QuartoEntity encontrado = optionalQuartoEntity.get();
        encontrado.setIdHotel(quarto.getIdHotel());
        encontrado.setPredio(new PredioEntity(quarto.getPredio()));
        encontrado.setTipoQuarto(new TipoQuartoEntity(quarto.getTipoQuarto()));
        encontrado.setStatus(quarto.getStatus());
        encontrado.setValorDiaria(quarto.getValorDiaria());

        return repository.save(encontrado).toEntity();
    }

    @Override
    public List<Quarto> listar() {
        return repository.findAll().stream().map(QuartoEntity::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<Quarto> buscarQuartoPorTipo(TipoQuarto tipoQuarto) {
        return repository.findByTipoQuarto(new TipoQuartoEntity(tipoQuarto)).stream().map(QuartoEntity::toEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Quarto> buscarPorId(Long id) {
        try {
            return repository.findById(id).map(QuartoEntity::toEntity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido");
        }
    }

    @Override
    public void deletar(Quarto quarto) {
        QuartoEntity quartoEntity = new QuartoEntity(quarto);
        repository.delete(quartoEntity);
    }

    @Override
    public List<Quarto> listarQuartoPorPeriodoDisponibilidade(LocalDate dataInicio, LocalDate dataFim, Status status) {
        List<QuartosDisponiveisDTO> quartosDisponiveisDTO = this.repository.listarQuartoPorPeriodoDisponibilidade(dataInicio, dataFim, status).orElseThrow();
        return  quartosDisponiveisDTO.stream().map(QuartosDisponiveisDTO::toQuarto).collect(Collectors.toList());

    }
}
