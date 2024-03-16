package com.fiap.desafioHackaton.infraestructure.hotel.item.controller;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.desafioHackaton.usecase.item.BuscarTodosItensUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Item", description = "Item API")
@RestController
public class BuscarTodosItensController {

    public BuscarTodosItensUseCase buscarTodosItensUseCase;

    public BuscarTodosItensController(BuscarTodosItensUseCase buscarTodosItensUseCase) {
        this.buscarTodosItensUseCase = buscarTodosItensUseCase;
    }

    @GetMapping("/items")
    @Operation(summary = "Buscar todos os items")
    public ResponseEntity<List<ItemPublicData>> buscarTodos() {
        List<Item> items = buscarTodosItensUseCase.execute();
        List<ItemPublicData> itemsPublicData = items.stream()
                .map(item -> new ItemPublicData(item))
                .collect(Collectors.toList());
        return ResponseEntity.ok(itemsPublicData);
    }
}