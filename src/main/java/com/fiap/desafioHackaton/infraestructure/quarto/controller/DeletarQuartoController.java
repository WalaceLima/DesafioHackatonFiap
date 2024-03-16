package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.usecase.quarto.usecases.DeletarQuartoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class DeletarQuartoController {

    private final DeletarQuartoUseCase deletarQuartoUseCase;

    public DeletarQuartoController(DeletarQuartoUseCase deletarQuartoUseCase) {
        this.deletarQuartoUseCase = deletarQuartoUseCase;
    }

    @DeleteMapping("/quartos/{id}")
    @Operation(summary = "Deletar quarto")
    public ResponseEntity<Void> deletarQuarto(@PathVariable Long id) {
        deletarQuartoUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}
