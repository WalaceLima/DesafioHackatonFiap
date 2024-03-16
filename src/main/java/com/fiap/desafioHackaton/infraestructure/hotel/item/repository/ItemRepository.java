package com.fiap.desafioHackaton.infraestructure.hotel.item.repository;

import com.fiap.desafioHackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}
