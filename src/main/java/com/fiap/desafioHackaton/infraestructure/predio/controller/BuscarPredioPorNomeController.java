package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.desafioHackaton.usecase.predio.BuscarPredioPorNomeUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Predio", description = "Predio API")
@Controller
public class BuscarPredioPorNomeController {

    private final BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase;

    public BuscarPredioPorNomeController(BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase) {
        this.buscarPredioPorNomeUseCase = buscarPredioPorNomeUseCase;
    }

    @GetMapping("/predio/nome/{nome}")
    @Operation(summary = "Buscar prédio por nome")
    public ResponseEntity<List<PredioPublicData>> buscarPredioPorNome(@PathVariable String nome) {
        List<Predio> response = this.buscarPredioPorNomeUseCase.execute(nome);
        return ResponseEntity.ok((response.stream().map(PredioPublicData::new).collect(Collectors.toList())));


    }

}
