package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.RemoverPredioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class RemoverPredioController {

    private final RemoverPredioUseCase removerPredioUseCase;


    public RemoverPredioController(RemoverPredioUseCase removerPredioUseCase) {
        this.removerPredioUseCase = removerPredioUseCase;
    }

    @DeleteMapping("/hotel/{idHotel}/predio/{idPredio}")
    @Operation(summary = "remove um predio de um hotel")
    public ResponseEntity<Void> removerPredio(@PathVariable Long idHotel, @PathVariable Long idPredio) {
        try {
            this.removerPredioUseCase.executar(idHotel, idPredio);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
