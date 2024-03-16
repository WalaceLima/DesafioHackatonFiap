package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.desafioHackaton.usecase.predio.BuscarTodosPrediosUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Predio", description = "Predio API")
@Controller
public class BuscarTodosPrediosController {

    private final BuscarTodosPrediosUseCase buscarTodosPrediosUseCase;

    public BuscarTodosPrediosController(BuscarTodosPrediosUseCase buscarTodosPrediosUseCase) {
        this.buscarTodosPrediosUseCase = buscarTodosPrediosUseCase;
    }


    @GetMapping("/predio")
    @Operation(summary = "Lista todos os Prédios")
    public ResponseEntity<List<PredioPublicData>> buscarTodosPredios() {
        List<Predio> response = this.buscarTodosPrediosUseCase.executar();
        return ResponseEntity.ok(response.stream().map(PredioPublicData::new).collect(Collectors.toList()));
    }
}
