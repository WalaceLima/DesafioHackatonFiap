package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.BuscarQuartoPorTipoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarQuartoPorTipoControllerTest {

    @Mock
    private BuscarQuartoPorTipoUseCase buscarQuartoPorTipoUseCase;

    @InjectMocks
    private BuscarQuartoPorTipoController buscarQuartoPorTipoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shouldReturnEmptyListWhenTipoDoesNotExist() {
        when(buscarQuartoPorTipoUseCase.execute(anyLong())).thenReturn(Arrays.asList());

        ResponseEntity<List<QuartoSearchResponseData>> response = buscarQuartoPorTipoController.buscarQuartoPorTipo(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}