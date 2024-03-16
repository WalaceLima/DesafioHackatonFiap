package com.fiap.desafioHackaton.infraestructure.reserva.controller;

import com.fiap.desafioHackaton.usecase.reserva.DeletarReservaPorIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class DeletarReservaPorIdController {

    private  final DeletarReservaPorIdUseCase deletarReservaPorIdUseCase;

    public DeletarReservaPorIdController(DeletarReservaPorIdUseCase deletarReservaPorIdUseCase) {
        this.deletarReservaPorIdUseCase = deletarReservaPorIdUseCase;
    }

    @DeleteMapping("/reservas/{id}")
    @Operation(summary = "Deletar reserva")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        deletarReservaPorIdUseCase.executar(id);
        return ResponseEntity.noContent().build();
    }
}
