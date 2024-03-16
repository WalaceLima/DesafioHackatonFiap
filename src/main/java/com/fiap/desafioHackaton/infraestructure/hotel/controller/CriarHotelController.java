package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCadastroRequestData;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.usecase.hotel.CriarHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class CriarHotelController {

    private final CriarHotelUseCase criarHotelUseCase;

    public CriarHotelController(CriarHotelUseCase criarHotelUseCase) {
        this.criarHotelUseCase = criarHotelUseCase;
    }

    @PostMapping("/hotel")
    @Operation(summary = "Criar Hotel")
    public ResponseEntity<HotelPublicData> criarHotel(@Valid @RequestBody HotelCadastroRequestData dados) {
      try {
        Hotel hotel = criarHotelUseCase.executar(dados);
        return ResponseEntity.ok(new HotelPublicData(hotel));
      } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
      }
    }

}
