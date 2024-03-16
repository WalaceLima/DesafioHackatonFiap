package com.fiap.desafioHackaton.infraestructure.hotel.item.gateway;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.desafioHackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemDatabaseGateway implements ItemGateway {

    private final ItemRepository repository;

    public ItemDatabaseGateway(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public Item criar(Item item) {
        ItemEntity itemEntity = new ItemEntity(item);
        return repository.save(itemEntity).toEntity();
    }

    @Override
    public Item atualizar(Item item) {
        if (item.getId() == null) {
            throw new IllegalArgumentException("Item ID não pode ser nulo ao atualizar");
        }
        Optional<ItemEntity> optionalItemEntity = repository.findById(item.getId());
        if (optionalItemEntity.isEmpty()) {
            throw new IllegalArgumentException("Item com ID " + item.getId() + " não encontrado");
        }
        ItemEntity encontrado = optionalItemEntity.get();
        encontrado.setNome(item.getNome());
        encontrado.setValor(item.getValor());
        return repository.save(encontrado).toEntity();
    }

    @Override
    public List<Item> listar() {
        return repository.findAll().stream().map(ItemEntity::toEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> buscarPorId(Long id) {
        Optional<ItemEntity> optionalItemEntity = repository.findById(id);
        if (optionalItemEntity.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(optionalItemEntity.get().toEntity());
    }

    @Override
    public void deletar(Item item) {
        ItemEntity itemEntity = new ItemEntity(item);
        repository.delete(itemEntity);
    }

}
