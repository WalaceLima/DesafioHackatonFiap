package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPrediosPublicData;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioRequestData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarPredioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class AdicionarPredioController {

    private final AdicionarPredioUseCase adicionarPredioUseCase;

    public AdicionarPredioController(AdicionarPredioUseCase adicionarPredioUseCase) {
        this.adicionarPredioUseCase = adicionarPredioUseCase;
    }


    @PostMapping("/hotel/{hotelId}/predio")
    @Operation(summary = "Adiciona um Predio ao Hotel")
    public ResponseEntity<HotelPrediosPublicData> adicionarPredio(@PathVariable Long hotelId, @RequestBody PredioRequestData predioRequestData) {
        Hotel response = this.adicionarPredioUseCase.executar(hotelId, predioRequestData);
        return ResponseEntity.ok(new HotelPrediosPublicData(response));
    }

}
