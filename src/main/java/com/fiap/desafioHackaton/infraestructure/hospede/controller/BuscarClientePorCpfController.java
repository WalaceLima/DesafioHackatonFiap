package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedePublicData;
import com.fiap.desafioHackaton.usecase.hospede.BuscarHospedePorCpfUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class BuscarClientePorCpfController {
    private final BuscarHospedePorCpfUseCase buscarHospedePorCpfUseCase;

    public BuscarClientePorCpfController(BuscarHospedePorCpfUseCase buscarHospedePorCpfUseCase) {
        this.buscarHospedePorCpfUseCase = buscarHospedePorCpfUseCase;
    }

    @GetMapping("/clientes/cpf/{cpf}")
    @Operation(summary = "Buscar hospede por cpf")
    public ResponseEntity<HospedePublicData> buscarClientePorCpf(@PathVariable String cpf) {
        Hospede hospede = buscarHospedePorCpfUseCase.execute(cpf);
        return ResponseEntity.ok(new HospedePublicData(hospede));
    }
}
