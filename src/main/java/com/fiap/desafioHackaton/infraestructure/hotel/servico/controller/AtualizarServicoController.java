package com.fiap.desafioHackaton.infraestructure.hotel.servico.controller;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoRequestData;
import com.fiap.desafioHackaton.usecase.servico.AtualizarServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Servico", description = "Servico API")
@RestController
public class AtualizarServicoController {
    private final AtualizarServicoUseCase atualizarServicoUseCase;

    public AtualizarServicoController(AtualizarServicoUseCase atualizarServicoUseCase) {
        this.atualizarServicoUseCase = atualizarServicoUseCase;
    }

    @PutMapping("/servicos/{id}")
    @Operation(summary = "Atualizar Servico")
    public ResponseEntity<ServicoPublicData> atualizarServico(@PathVariable Long id, @Valid @RequestBody ServicoRequestData dados) {
        Servico servico = atualizarServicoUseCase.execute(id, dados);
        return ResponseEntity.ok(new ServicoPublicData(servico));
    }
}