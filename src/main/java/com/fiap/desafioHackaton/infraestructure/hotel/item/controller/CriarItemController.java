package com.fiap.desafioHackaton.infraestructure.hotel.item.controller;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemRequestData;
import com.fiap.desafioHackaton.usecase.item.CriarItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Item", description = "Item API")
@RestController
public class CriarItemController {

    private final CriarItemUseCase criarItemUseCase;

    public CriarItemController(CriarItemUseCase criarItemUseCase) {
        this.criarItemUseCase = criarItemUseCase;
    }

    @PostMapping("/items")
    @Operation(summary = "Criar item")
    public ResponseEntity<ItemPublicData> criarItem(@Valid @RequestBody ItemRequestData dados) {
        Item item = criarItemUseCase.executar(dados);
        return ResponseEntity.ok(new ItemPublicData(item));
    }
}