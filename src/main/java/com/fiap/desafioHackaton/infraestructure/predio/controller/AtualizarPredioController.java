package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioAtualizarRequestData;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicResponseAddData;
import com.fiap.desafioHackaton.usecase.predio.AtualizarPredioUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Predio", description = "Predio API")
@Controller
public class AtualizarPredioController {

    private final AtualizarPredioUseCase atualizarPredioUseCase;

    public AtualizarPredioController(AtualizarPredioUseCase atualizarPredioUseCase) {
        this.atualizarPredioUseCase = atualizarPredioUseCase;
    }

    @PutMapping("/predio/{id}")
    @Operation(summary = "Atualizar Predio")
    public ResponseEntity<PredioPublicResponseAddData> atualizarPredio(@PathVariable Long id, @RequestBody PredioAtualizarRequestData dados) {
      try {
          Predio predio = this.atualizarPredioUseCase.executar(id, dados);
          return ResponseEntity.ok(new PredioPublicResponseAddData(predio));
      } catch (Exception e) {
        return ResponseEntity.notFound().build();
      }
    }
}
