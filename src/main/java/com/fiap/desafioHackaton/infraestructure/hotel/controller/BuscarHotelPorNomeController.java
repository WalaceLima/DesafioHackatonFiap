package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorNomeUseCase;
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
public class BuscarHotelPorNomeController {

    private final BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase;

    public BuscarHotelPorNomeController(BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase) {
        this.buscarHotelPorNomeUseCase = buscarHotelPorNomeUseCase;
    }

    @GetMapping("/hotel/nome/{nome}")
    @Operation(summary = "Buscar todos os hoteis por nome")
    public ResponseEntity<List<HotelCompletePublicData>> buscarTodosOsHoteisPorNome(@PathVariable String nome) {
        List<HotelCompletePublicData> response = this.buscarHotelPorNomeUseCase.executar(nome).stream().map(HotelCompletePublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
