package com.fiap.desafioHackaton.infraestructure.tipoquarto.gateway;

import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.repository.TipoQuartoRepository;

import java.util.List;

public class TipoQuartoDatabaseGateway implements TipoQuartoGateway {

    private final TipoQuartoRepository repository;

    public TipoQuartoDatabaseGateway(TipoQuartoRepository repository) {
        this.repository = repository;
    }


    @Override
    public TipoQuarto buscarPorId(Long id) {
        return repository.findById(id).orElseThrow().toEntity();
    }

    @Override
    public List<TipoQuarto> buscaTiposQuartoPorCapacidadeTotal(Long capacidadeTotal) {
        List<TipoQuartoEntity> listTipoQuartoEntity = repository.findByCapacidadeTotalGreaterThanEqual(capacidadeTotal);
        return TipoQuartoEntity.toTipoQuartoList(listTipoQuartoEntity);
    }
}
