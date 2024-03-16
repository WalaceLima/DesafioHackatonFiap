package com.fiap.desafioHackaton.infraestructure.reserva.controller;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.infraestructure.reserva.dto.ReservaPublicData;
import com.fiap.desafioHackaton.usecase.reserva.ListarReservasDeUmPeriodoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class ListarReservasDeUmPeriodoController {

    private final ListarReservasDeUmPeriodoUseCase listarReservasDeUmPeriodoUseCase;

    public ListarReservasDeUmPeriodoController(ListarReservasDeUmPeriodoUseCase listarReservasDeUmPeriodoUseCase) {
        this.listarReservasDeUmPeriodoUseCase = listarReservasDeUmPeriodoUseCase;
    }

    @GetMapping("/reservas/periodo")
    @Operation(summary = "Listar reservas de um período")
    public ResponseEntity<List<ReservaPublicData>> buscarReservasPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        List<Reserva> reservas = listarReservasDeUmPeriodoUseCase.executar(dataInicial, dataFinal);
        List<ReservaPublicData> response = reservas.stream()
                .map(reserva -> new ReservaPublicData(reserva))
                .collect(java.util.stream.Collectors.toList());
        return  ResponseEntity.ok(response);
    }


}
