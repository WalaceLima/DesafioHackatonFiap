package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedePublicData;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedeRequestData;
import com.fiap.desafioHackaton.usecase.hospede.AtualizarHospedeeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class AtualizarHospedeController {
    private final AtualizarHospedeeUseCase atualizarHospedeeUseCase;

    public AtualizarHospedeController(AtualizarHospedeeUseCase atualizarHospedeeUseCase) {
        this.atualizarHospedeeUseCase = atualizarHospedeeUseCase;
    }

    @PutMapping("/clientes/{id}")
    @Operation(summary = "Atualizar Cliente")
    public ResponseEntity<HospedePublicData> atualizarCliente(@PathVariable Long id, @Valid @RequestBody HospedeRequestData dados) {
        Hospede hospede = atualizarHospedeeUseCase.execute(id, dados);
        return ResponseEntity.ok(new HospedePublicData(hospede));
    }
}
