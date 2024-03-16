package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelServicosPublicData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarServicoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class AdicionarServicoController {

    private final AdicionarServicoUseCase adicionarServicoUseCase;

    public AdicionarServicoController(AdicionarServicoUseCase adicionarServicoUseCase) {
        this.adicionarServicoUseCase = adicionarServicoUseCase;
    }


    @PostMapping("/hotel/{idHotel}/adicionarservico/{idServico}")
    @Operation(summary = "Adiciona um servico a um hotel")
    public ResponseEntity<HotelServicosPublicData> adicionarServicoaHotel(@PathVariable Long idHotel, @PathVariable Long idServico) {
        Hotel hotel = this.adicionarServicoUseCase.executar(idHotel, idServico);
        return ResponseEntity.ok(new HotelServicosPublicData(hotel));
    }
}
