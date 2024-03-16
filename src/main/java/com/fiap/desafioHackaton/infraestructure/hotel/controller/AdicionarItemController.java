package com.fiap.desafioHackaton.infraestructure.hotel.controller;


import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelItensPublicData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class AdicionarItemController {

    private final AdicionarItemUseCase adicionarItemUseCase;

    public AdicionarItemController(AdicionarItemUseCase adicionarItemUseCase) {
        this.adicionarItemUseCase = adicionarItemUseCase;
    }

    @PostMapping("/hotel/{idHotel}/item/{idItem}")
    @Operation(summary = "Adiciona um item a um hotel")
    public ResponseEntity<HotelItensPublicData> adicionarItemaoHotel(@PathVariable Long idHotel, @PathVariable Long idItem) {
        Hotel hotel = this.adicionarItemUseCase.executar(idHotel, idItem);
        return ResponseEntity.ok(new HotelItensPublicData(hotel));
    }
}
