package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.DeletarHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class DeletarHotelController {


    private final DeletarHotelUseCase deletarHotelUseCase;


    public DeletarHotelController(DeletarHotelUseCase deletarHotelUseCase) {
        this.deletarHotelUseCase = deletarHotelUseCase;
    }

    @DeleteMapping("/hotel/{id}")
    @Operation(summary = "deletar Hotel por id")
    public ResponseEntity<Void> deletarHotel(@PathVariable("id") Long id) {
        try {
            this.deletarHotelUseCase.executar(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
