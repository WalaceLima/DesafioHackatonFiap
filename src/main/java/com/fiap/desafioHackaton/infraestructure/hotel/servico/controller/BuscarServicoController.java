package com.fiap.desafioHackaton.infraestructure.hotel.servico.controller;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.desafioHackaton.usecase.servico.BuscarServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Servico", description = "Servico API")
@RestController
public class BuscarServicoController {
    private final BuscarServicoUseCase buscarServicoUseCase;

    public BuscarServicoController(BuscarServicoUseCase buscarServicoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    @GetMapping("/servicos/{id}")
    @Operation(summary = "Buscar servico por id")
    public ResponseEntity<ServicoPublicData> buscarServico(@PathVariable Long id) {
        Servico servico = buscarServicoUseCase.execute(id);
        return ResponseEntity.ok(new ServicoPublicData(servico));
    }
}