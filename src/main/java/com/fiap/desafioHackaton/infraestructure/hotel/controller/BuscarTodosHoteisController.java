package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarTodosHoteisUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class BuscarTodosHoteisController {

    private final BuscarTodosHoteisUseCase buscarTodosHoteisUseCase;

    public BuscarTodosHoteisController(BuscarTodosHoteisUseCase buscarTodosHoteisUseCase) {
        this.buscarTodosHoteisUseCase = buscarTodosHoteisUseCase;
    }

    @GetMapping("/hotel")
    @Operation(summary = "buscar todos os hoteis")
    public ResponseEntity<List<HotelPublicData>> buscarTodososHoteis() {

        List<HotelPublicData> response = this.buscarTodosHoteisUseCase.executar().stream().map(HotelPublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }


}
