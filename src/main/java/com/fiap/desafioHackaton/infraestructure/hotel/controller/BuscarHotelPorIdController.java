package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class BuscarHotelPorIdController {

    private final BuscarHotelPorIdUseCase buscarHotelPorIdUseCase;

    public BuscarHotelPorIdController(BuscarHotelPorIdUseCase buscarHotelPorIdUseCase) {
        this.buscarHotelPorIdUseCase = buscarHotelPorIdUseCase;
    }

    @GetMapping("/hotel/{id}")
    @Operation(summary = "Busca um hotel por Id")
    public ResponseEntity<HotelCompletePublicData> buscarHotelPorId(@PathVariable Long id) {
        Hotel hotel = this.buscarHotelPorIdUseCase.buscarPorId(id);
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new HotelCompletePublicData(hotel));
    }

}
