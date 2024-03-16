package com.fiap.desafioHackaton.infraestructure.reserva.controller;

import com.fiap.desafioHackaton.usecase.reserva.FechamentoReservaUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class FecharReservaController {

    private FechamentoReservaUseCase fechamentoReservaUseCase;

    public FecharReservaController(FechamentoReservaUseCase fechamentoReservaUseCase) {
        this.fechamentoReservaUseCase = fechamentoReservaUseCase;
    }

    @PostMapping("/confirmar/{idReserva}")
    public ResponseEntity<String> fecharReserva(@PathVariable Long idReserva) throws Exception {
        return ResponseEntity.ok(fechamentoReservaUseCase.fecharReserva(idReserva));
    }
}
