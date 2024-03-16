package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.BuscarQuartoPorQuantidadeDeHospedesUseCase;
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
public class BuscarQuartoPorQuantidadeDeHospedesController {
    private final BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase;

    public BuscarQuartoPorQuantidadeDeHospedesController(BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase) {
        this.buscarQuartoPorQuantidadeDeHospedesUseCase = buscarQuartoPorQuantidadeDeHospedesUseCase;
    }

    @GetMapping("/quartos/quantidadeHospedes/{quantidadeHospedes}")
    @Operation(summary = "Buscar quarto por quantidade de hóspedes")
    public ResponseEntity<List<QuartoSearchResponseData>> buscarQuarto(@PathVariable Long quantidadeHospedes) {
        List<Quarto> quartos = buscarQuartoPorQuantidadeDeHospedesUseCase.execute(quantidadeHospedes);
        List<QuartoSearchResponseData> quartosPublicData = quartos.stream()
                .map(quarto -> new QuartoSearchResponseData(quarto))
                .collect(Collectors.toList());
        return ResponseEntity.ok(quartosPublicData);
    }
}
