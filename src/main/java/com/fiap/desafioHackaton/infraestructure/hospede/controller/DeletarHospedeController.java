package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.usecase.hospede.DeletarHospedeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Cliente", description = "Gestão de Cliente API")
@RestController
public class DeletarHospedeController {

    private final DeletarHospedeUseCase deletarHospedeUseCase;

    public DeletarHospedeController(DeletarHospedeUseCase deletarHospedeUseCase) {
        this.deletarHospedeUseCase = deletarHospedeUseCase;
    }

    @DeleteMapping("/clientes/{id}")
    @Operation(summary = "Deletar hospede")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        deletarHospedeUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
