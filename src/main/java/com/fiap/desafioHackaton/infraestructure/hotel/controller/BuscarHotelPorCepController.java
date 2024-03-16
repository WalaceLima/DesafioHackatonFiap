package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorCEPUseCase;
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
public class BuscarHotelPorCepController {

    private final BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase;

    public BuscarHotelPorCepController(BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase) {
        this.buscarHotelPorCEPUseCase = buscarHotelPorCEPUseCase;
    }


    @GetMapping("hotel/cep/{cep}")
    @Operation(summary = "Buscar por CEP")
    public ResponseEntity<List<HotelCompletePublicData>> buscarHotelPorCep(@PathVariable("cep") String cep) {
        List<HotelCompletePublicData> response = this.buscarHotelPorCEPUseCase.executar(cep).stream().map(HotelCompletePublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);

    }
}
