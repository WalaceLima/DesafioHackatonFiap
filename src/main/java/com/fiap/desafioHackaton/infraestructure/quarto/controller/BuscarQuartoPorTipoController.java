package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.BuscarQuartoPorTipoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class BuscarQuartoPorTipoController {

    private final BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase;

    public BuscarQuartoPorTipoController(BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase) {
        this.buscarQuartoPorTipoUseCase = buscarQuartoPorTipoUseCase;
    }

    @GetMapping("/quartos/tipo/{idTipoQuarto}")
    @Operation(summary = "Buscar quarto por tipo de quarto")
    public ResponseEntity<List<QuartoSearchResponseData>> buscarQuartoPorTipo(@PathVariable Long idTipoQuarto) {
        List<Quarto> quartos = buscarQuartoPorTipoUseCase.execute(idTipoQuarto);
        List<QuartoSearchResponseData> quartosPublicData = quartos.stream()
                .map(quarto -> new QuartoSearchResponseData(quarto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(quartosPublicData);
    }
}
