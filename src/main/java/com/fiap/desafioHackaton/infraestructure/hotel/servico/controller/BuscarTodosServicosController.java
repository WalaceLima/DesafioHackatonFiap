package com.fiap.desafioHackaton.infraestructure.hotel.servico.controller;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.desafioHackaton.usecase.servico.BuscarTodosServicosUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Servico", description = "Servico API")
@RestController
public class BuscarTodosServicosController {

    public BuscarTodosServicosUseCase buscarTodosServicosUseCase;

    public BuscarTodosServicosController(BuscarTodosServicosUseCase buscarTodosServicosUseCase) {
        this.buscarTodosServicosUseCase = buscarTodosServicosUseCase;
    }

    @GetMapping("/servicos")
    @Operation(summary = "Buscar todos os servicos")
    public ResponseEntity<List<ServicoPublicData>> buscarTodos() {
        List<Servico> servicos = buscarTodosServicosUseCase.execute();
        List<ServicoPublicData> servicosPublicData = servicos.stream()
                .map(servico -> new ServicoPublicData(servico))
                .collect(Collectors.toList());
        return ResponseEntity.ok(servicosPublicData);
    }
}