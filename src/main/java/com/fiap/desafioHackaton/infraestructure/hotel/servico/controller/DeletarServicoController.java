package com.fiap.desafioHackaton.infraestructure.hotel.servico.controller;

import com.fiap.desafioHackaton.usecase.servico.DeletarServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Servico", description = "Servico API")
@RestController
public class DeletarServicoController {

    private final DeletarServicoUseCase deletarServicoUseCase;

    public DeletarServicoController(DeletarServicoUseCase deletarServicoUseCase) {
        this.deletarServicoUseCase = deletarServicoUseCase;
    }

    @DeleteMapping("/servicos/{id}")
    @Operation(summary = "Deletar servico")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        deletarServicoUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}