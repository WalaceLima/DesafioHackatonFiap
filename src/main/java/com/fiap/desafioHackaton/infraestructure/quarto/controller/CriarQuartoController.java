package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.CriarQuartoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class CriarQuartoController {

    private final CriarQuartoUseCase criarQuartoUseCase;

    public CriarQuartoController(CriarQuartoUseCase criarQuartoUseCase) {
        this.criarQuartoUseCase = criarQuartoUseCase;
    }

    @PostMapping("/quartos")
    @Operation(summary = "Criar quarto")
    public ResponseEntity<QuartoPublicData> criarQuarto(@Valid @RequestBody QuartoRequestData dados) {
        Quarto quarto = criarQuartoUseCase.executar(dados);
        return ResponseEntity.ok(new QuartoPublicData(quarto));
    }
}
