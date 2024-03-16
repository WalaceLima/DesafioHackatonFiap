package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioAtualizarRequestData;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicResponseAddData;
import com.fiap.desafioHackaton.usecase.predio.AtualizarPredioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtualizarPredioControllerTest {

    private AtualizarPredioUseCase atualizarPredioUseCase;
    private AtualizarPredioController controller;

    @BeforeEach
    public void setUp() {
        atualizarPredioUseCase = Mockito.mock(AtualizarPredioUseCase.class);
        controller = new AtualizarPredioController(atualizarPredioUseCase);
    }

    @Test
    public void shouldUpdateBuilding() {
        Predio predio = new Predio();
        PredioAtualizarRequestData requestData = mock(PredioAtualizarRequestData.class);
        when(atualizarPredioUseCase.executar(1L, requestData)).thenReturn(predio);

        ResponseEntity<PredioPublicResponseAddData> responseEntity = controller.atualizarPredio(1L, requestData);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(new PredioPublicResponseAddData(predio), responseEntity.getBody());
    }

    @Test
    public void shouldNotUpdateBuildingWhenBuildingDoesNotExist() {
        PredioAtualizarRequestData requestData = mock(PredioAtualizarRequestData.class);
        when(atualizarPredioUseCase.executar(1L, requestData)).thenReturn(null);

        ResponseEntity<PredioPublicResponseAddData> responseEntity = controller.atualizarPredio(1L, requestData);

        assertEquals(404, responseEntity.getStatusCodeValue());
    }
}