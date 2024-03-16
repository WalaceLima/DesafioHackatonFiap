package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoHotelPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.RecomendarQuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecomendarQuartosDisponiveisControllerTest {

    @Mock
    private ExibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva;

    @InjectMocks
    private RecomendarQuartosDisponiveisController recomendarQuartosDisponiveisController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnRecommendationsWhenQuartosExist() {
        Quarto quarto = mock(Quarto.class);
        RecomendarQuartoRequestData requestData = mock(RecomendarQuartoRequestData.class);
        when(exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva.execute(requestData.dataInicio(), requestData.dataFim(), requestData.quantidadePessoas(), requestData.numeroSugestoes())).thenReturn(Arrays.asList(Arrays.asList(quarto)));

        ResponseEntity<List<List<QuartoHotelPublicData>>> response = recomendarQuartosDisponiveisController.gerarRecomendacoesDeQuarto(requestData);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void shouldReturnEmptyListWhenNoQuartosExist() {
        RecomendarQuartoRequestData requestData = mock(RecomendarQuartoRequestData.class);
        when(exibirPossibilidadesDeQuartosDisponiveisParaAtenderReserva.execute(requestData.dataInicio(), requestData.dataFim(), requestData.quantidadePessoas(), requestData.numeroSugestoes())).thenReturn(Arrays.asList());

        ResponseEntity<List<List<QuartoHotelPublicData>>> response = recomendarQuartosDisponiveisController.gerarRecomendacoesDeQuarto(requestData);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}