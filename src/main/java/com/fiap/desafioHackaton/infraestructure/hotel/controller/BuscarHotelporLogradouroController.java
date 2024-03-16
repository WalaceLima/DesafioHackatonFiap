package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorLogradouroUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class BuscarHotelporLogradouroController {


    private final BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase;

    public BuscarHotelporLogradouroController(BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase) {
        this.buscarHotelPorLogradouroUseCase = buscarHotelPorLogradouroUseCase;
    }

    @GetMapping("/hotel/logradouro/{logradouro}")
    @Operation(summary = "Buscar Hotel por Logradouro")
    public ResponseEntity<List<HotelCompletePublicData>> buscarHotelPorLogradouro(@PathVariable String logradouro) {
        List<HotelCompletePublicData> response = this.buscarHotelPorLogradouroUseCase.executar(logradouro).stream().map(HotelCompletePublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }

}
