package com.fiap.desafioHackaton.infraestructure.hotel.servico.controller;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoRequestData;
import com.fiap.desafioHackaton.usecase.servico.CriarServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Servico", description = "Servico API")
@RestController
public class CriarServicoController {

    private final CriarServicoUseCase criarServicoUseCase;

    public CriarServicoController(CriarServicoUseCase criarServicoUseCase) {
        this.criarServicoUseCase = criarServicoUseCase;
    }

    @PostMapping("/servicos")
    @Operation(summary = "Criar servico")
    public ResponseEntity<ServicoPublicData> criarServico(@Valid @RequestBody ServicoRequestData dados) {
        Servico servico = criarServicoUseCase.executar(dados);
        return ResponseEntity.ok(new ServicoPublicData(servico));
    }
}