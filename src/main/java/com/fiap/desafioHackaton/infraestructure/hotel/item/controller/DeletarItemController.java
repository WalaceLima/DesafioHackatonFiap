package com.fiap.desafioHackaton.infraestructure.hotel.item.controller;

import com.fiap.desafioHackaton.usecase.item.DeletarItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Item", description = "Item API")
@RestController
public class DeletarItemController {

    private final DeletarItemUseCase deletarItemUseCase;

    public DeletarItemController(DeletarItemUseCase deletarItemUseCase) {
        this.deletarItemUseCase = deletarItemUseCase;
    }

    @DeleteMapping("/items/{id}")
    @Operation(summary = "Deletar item")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        deletarItemUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}