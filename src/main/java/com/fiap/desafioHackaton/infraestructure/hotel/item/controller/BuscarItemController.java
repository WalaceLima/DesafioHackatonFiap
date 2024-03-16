package com.fiap.desafioHackaton.infraestructure.hotel.item.controller;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.desafioHackaton.usecase.item.BuscarItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Item", description = "Item API")
@RestController
public class BuscarItemController {
    private final BuscarItemUseCase buscarItemUseCase;

    public BuscarItemController(BuscarItemUseCase buscarItemUseCase) {
        this.buscarItemUseCase = buscarItemUseCase;
    }

    @GetMapping("/items/{id}")
    @Operation(summary = "Buscar item por id")
    public ResponseEntity<ItemPublicData> buscarItem(@PathVariable Long id) {
        Item item = buscarItemUseCase.execute(id);
        return ResponseEntity.ok(new ItemPublicData(item));
    }
}