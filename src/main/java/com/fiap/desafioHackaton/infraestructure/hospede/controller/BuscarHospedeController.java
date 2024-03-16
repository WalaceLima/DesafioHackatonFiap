package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedePublicData;
import com.fiap.desafioHackaton.usecase.hospede.BuscarClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class BuscarHospedeController {
    private final BuscarClienteUseCase buscarClienteUseCase;

    public BuscarHospedeController(BuscarClienteUseCase buscarClienteUseCase) {
        this.buscarClienteUseCase = buscarClienteUseCase;
    }

    @GetMapping("/clientes/{id}")
    @Operation(summary = "Buscar hospede por id")
    public ResponseEntity<HospedePublicData> buscarCliente(@PathVariable Long id) {
        Hospede hospede = buscarClienteUseCase.execute(id);
        return ResponseEntity.ok(new HospedePublicData(hospede));
    }
}
