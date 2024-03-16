package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedePublicData;
import com.fiap.desafioHackaton.usecase.hospede.BuscarTodosHospedeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class BuscarTodosHospedeController {

    public BuscarTodosHospedeUseCase buscarTodosHospedeUseCase;

    public BuscarTodosHospedeController(BuscarTodosHospedeUseCase buscarTodosHospedeUseCase) {
        this.buscarTodosHospedeUseCase = buscarTodosHospedeUseCase;
    }

    @GetMapping("/clientes")
    @Operation(summary = "Buscar todos os clientes")
    public ResponseEntity<List<HospedePublicData>> buscarTodos() {
        List<Hospede> hospedes = buscarTodosHospedeUseCase.execute();
        List<HospedePublicData> clientesPublicData = hospedes.stream()
                .map(cliente -> new HospedePublicData(cliente))
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientesPublicData);
    }
}
