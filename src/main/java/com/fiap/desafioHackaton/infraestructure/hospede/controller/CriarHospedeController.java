package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedePublicData;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedeRequestData;
import com.fiap.desafioHackaton.usecase.hospede.CriarHospedeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class CriarHospedeController {

    private final CriarHospedeUseCase criarHospedeUseCase;

    public CriarHospedeController(CriarHospedeUseCase criarHospedeUseCase) {
        this.criarHospedeUseCase = criarHospedeUseCase;
    }

    @PostMapping("/clientes")
    @Operation(summary = "Criar hospede")
    public ResponseEntity<HospedePublicData> criarCliente(@Valid @RequestBody HospedeRequestData dados) {
        Hospede hospede = criarHospedeUseCase.executar(dados);
        return ResponseEntity.ok(new HospedePublicData(hospede));
    }
}
