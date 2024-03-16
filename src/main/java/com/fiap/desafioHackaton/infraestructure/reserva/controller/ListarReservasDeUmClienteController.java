package com.fiap.desafioHackaton.infraestructure.reserva.controller;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.infraestructure.reserva.dto.ReservaPublicData;
import com.fiap.desafioHackaton.usecase.reserva.ListarReservasDeUmClienteUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class ListarReservasDeUmClienteController {

    private final ListarReservasDeUmClienteUseCase listarReservasDeUmClienteUseCase;

    public  ListarReservasDeUmClienteController(ListarReservasDeUmClienteUseCase listarReservasDeUmClienteUseCase) {
        this.listarReservasDeUmClienteUseCase = listarReservasDeUmClienteUseCase;
    }

    @GetMapping("/reservas/cliente/{cpf}")
    @Operation(summary = "Listar reservas de um hospede")
    public ResponseEntity<List<ReservaPublicData>> buscarReservasCliente(@PathVariable String cpf) {
        List<Reserva> reservas = listarReservasDeUmClienteUseCase.executar(cpf);
        List<ReservaPublicData> response = reservas.stream()
                .map(reserva -> new ReservaPublicData(reserva))
                .collect(java.util.stream.Collectors.toList());
        return  ResponseEntity.ok(response);
    }

}
