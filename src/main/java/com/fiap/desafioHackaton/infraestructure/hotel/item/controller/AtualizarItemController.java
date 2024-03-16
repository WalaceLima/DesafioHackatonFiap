package com.fiap.desafioHackaton.infraestructure.hotel.item.controller;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemRequestData;
import com.fiap.desafioHackaton.usecase.item.AtualizarItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Item", description = "Item API")
@RestController
public class AtualizarItemController {
    private final AtualizarItemUseCase atualizarItemUseCase;

    public AtualizarItemController(AtualizarItemUseCase atualizarItemUseCase) {
        this.atualizarItemUseCase = atualizarItemUseCase;
    }

    @PutMapping("/items/{id}")
    @Operation(summary = "Atualizar Item")
    public ResponseEntity<ItemPublicData> atualizarItem(@PathVariable Long id, @Valid @RequestBody ItemRequestData dados) {
        Item item = atualizarItemUseCase.execute(id, dados);
        return ResponseEntity.ok(new ItemPublicData(item));
    }
}