package com.fiap.desafioHackaton.infraestructure.reserva.controller;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.infraestructure.reserva.dto.ReservaPublicData;
import com.fiap.desafioHackaton.usecase.reserva.ListarReservasDeUmHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Reserva", description = "Gestão de Reservas API")
@RestController
public class ListarReservasDeUmHotelController {

    private final ListarReservasDeUmHotelUseCase listarReservasDeUmHotelUseCase;

    public ListarReservasDeUmHotelController(ListarReservasDeUmHotelUseCase listarReservasDeUmHotelUseCase) {
        this.listarReservasDeUmHotelUseCase = listarReservasDeUmHotelUseCase;
    }

    @GetMapping("/reservas/hotel/{id}")
    @Operation(summary = "Listar reservas de um hotel")
    public ResponseEntity<List<ReservaPublicData>> buscarReservasHotel(@PathVariable Long id) {
        List<Reserva> reservas = listarReservasDeUmHotelUseCase.executar(id);
        List<ReservaPublicData> response = reservas.stream()
                .map(reserva -> new ReservaPublicData(reserva))
                .collect(java.util.stream.Collectors.toList());
        return  ResponseEntity.ok(response);
    }

}
