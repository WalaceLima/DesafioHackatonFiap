package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoHotelPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.RecomendarQuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Tag(name = "Quarto", description = "Gestão de Quarto API")
@RestController
public class RecomendarQuartosDisponiveisController {

    private final ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva;


    public RecomendarQuartosDisponiveisController(ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva) {
        this.exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva = exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva;
    }

    @PostMapping("/quarto/recomendarQuartos")
    @Operation(summary = "recomenda os quartos baseado em um periodo e quantidade de pessoas")
    public ResponseEntity<List<List<QuartoHotelPublicData>>> gerarRecomendacoesDeQuarto (@RequestBody RecomendarQuartoRequestData recomendarQuartoRequestData) {
        List<List<Quarto>> quartoList = this.exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva.execute(
                recomendarQuartoRequestData.dataInicio(),
                recomendarQuartoRequestData.dataFim(),
                recomendarQuartoRequestData.quantidadePessoas(),
                recomendarQuartoRequestData.numeroSugestoes()
        );

        List<List<QuartoHotelPublicData>> response = quartoList.stream().map(
                quartos -> quartos.stream().map(QuartoHotelPublicData::new).collect(Collectors.toList())
        ).collect(Collectors.toList());

        return ResponseEntity.ok(response);

    }


}
