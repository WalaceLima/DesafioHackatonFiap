package com.fiap.desafioHackaton.infraestructure.quarto.controller;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.BuscarTodosQuartosUseCase;
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

public class BuscarTodosQuartosControllerTest {

    @Mock
    private BuscarTodosQuartosUseCase buscarTodosQuartosUseCase;

    @InjectMocks
    private BuscarTodosQuartosController buscarTodosQuartosController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnQuartosWhenQuartosExist() {
        Quarto quarto = mock(Quarto.class);
        Predio predioMock = mock(Predio.class);
        when(predioMock.getId()).thenReturn(1L);
        when(quarto.getPredio()).thenReturn(predioMock);
        when(buscarTodosQuartosUseCase.execute()).thenReturn(Arrays.asList(quarto));

        ResponseEntity<List<QuartoSearchResponseData>> response = buscarTodosQuartosController.buscarQuartos();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }


    @Test
    public void shouldReturnEmptyListWhenNoQuartosExist() {
        when(buscarTodosQuartosUseCase.execute()).thenReturn(Arrays.asList());

        ResponseEntity<List<QuartoSearchResponseData>> response = buscarTodosQuartosController.buscarQuartos();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}