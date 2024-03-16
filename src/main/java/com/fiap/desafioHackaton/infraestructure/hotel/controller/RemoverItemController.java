package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.RemoverItemUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class RemoverItemController {


    private final RemoverItemUseCase removerItemUseCase;

    public RemoverItemController(RemoverItemUseCase removerItemUseCase) {
        this.removerItemUseCase = removerItemUseCase;
    }

    @DeleteMapping("/hotel/{idHotel}/item/{idItem}")
    @Operation(summary = "remove um item de um hotel")
    public ResponseEntity<Void> removerItemdeHotel(@PathVariable Long idHotel, @PathVariable Long idItem) {
        try {
            this.removerItemUseCase.executar(idHotel, idItem);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
