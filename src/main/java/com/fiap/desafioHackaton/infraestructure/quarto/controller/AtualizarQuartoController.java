package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.AtualizarQuartoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class AtualizarQuartoController {

    private final AtualizarQuartoUseCase atualizarQuartoUseCase;

    public AtualizarQuartoController(AtualizarQuartoUseCase atualizarQuartoUseCase) {
        this.atualizarQuartoUseCase = atualizarQuartoUseCase;
    }

    @PutMapping("/quartos/{id}")
    @Operation(summary = "Atualizar Quarto")
    public ResponseEntity<QuartoPublicData> atualizarQuarto(@PathVariable Long id, @Valid @RequestBody QuartoRequestData dados) {
        Quarto quarto = atualizarQuartoUseCase.execute(id, dados);
        return ResponseEntity.ok(new QuartoPublicData(quarto));
    }
}
