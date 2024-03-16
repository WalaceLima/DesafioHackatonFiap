package com.fiap.desafioHackaton.infraestructure.hotel.gateway;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.hotel.entityschema.HotelEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.repository.HotelRepository;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelDatabaseGateway implements HotelGateway {

    private final HotelRepository repository;

    public HotelDatabaseGateway(HotelRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hotel criar(Hotel hotel) {
        HotelEntity entity = new HotelEntity(hotel);
        return this.repository.save(entity).toEntity();
    }

    @Override
    public Hotel atualizar(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            return this.repository.save(entity).toEntity();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Hotel adicionarPredio(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            entity.setPredios(hotel.getPredios().stream().map(PredioEntity::new).collect(Collectors.toList()));
            return this.repository.save(entity).toEntityWithPredios();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Hotel adicionarServico(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            entity.setServicos(hotel.getServicosDisponiveis().stream().map(ServicoEntity::new).collect(Collectors.toSet()));
            return this.repository.save(entity).toEntityWithServicos();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Hotel adicionarItem(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            entity.setItens(hotel.getItensDiponiveis().stream().map(ItemEntity::new).collect(Collectors.toSet()));
            return this.repository.save(entity).toEntityWithItens();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Hotel> listar() {
        try {
            return this.repository.findAll().stream().map(HotelEntity::toEntity).collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<Hotel> buscarPorId(Long id) {
        try {
            return this.repository.findById(id).map(HotelEntity::toCompleteEntity);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Hotel>> buscarPorNome(String nome) {
        try {
            return this.repository.findByNome(nome).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Hotel>> buscarPorLogradouro(String endereco) {
        try {
            return this.repository.findByEnderecoLogradouro(endereco).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Hotel>> buscarPorCep(String cep) {
        try {
            return this.repository.findByEnderecoCep(cep).map(l -> l.stream().map(HotelEntity::toCompleteEntity).collect(Collectors.toList()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deletar(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            this.repository.delete(entity);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public Hotel removerServico(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            entity.setServicos(hotel.getServicosDisponiveis().stream().map(ServicoEntity::new).collect(Collectors.toSet()));
            return this.repository.save(entity).toEntityWithServicos();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Hotel removerItem(Hotel hotel) {
        try {
            HotelEntity entity = new HotelEntity(hotel);
            entity.setItens(hotel.getItensDiponiveis().stream().map(ItemEntity::new).collect(Collectors.toSet()));
            return this.repository.save(entity).toEntityWithItens();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void removerRelacionamentoItem(Item item){
        List<HotelEntity> hoteis = repository.findAll();
        hoteis.forEach(hotel -> hotel.getItens().removeIf(itemEntity -> itemEntity.getId().equals(item.getId())));
        repository.saveAll(hoteis);
    }

    @Override
    public void removerRelacionamentoServico(Servico servico){
        List<HotelEntity> hoteis = repository.findAll();
        hoteis.forEach(hotel -> hotel.getServicos().removeIf(ServicoEntity -> ServicoEntity.getId().equals(servico.getId())));
        repository.saveAll(hoteis);
    }
}
