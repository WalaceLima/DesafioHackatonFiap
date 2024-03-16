package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.IndisponibilizarQuartoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class IndisponibilizarQuartoControllerTest {

    @Mock
    private IndisponibilizarQuartoUseCase indisponibilizarQuartoUseCase;

    @InjectMocks
    private IndisponibilizarQuartoController indisponibilizarQuartoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldIndisponibilizarQuartoSuccessfully() {
        Quarto quarto = new Quarto();
        when(indisponibilizarQuartoUseCase.executar(1L)).thenReturn(quarto);

        ResponseEntity<QuartoPublicData> response = indisponibilizarQuartoController.indisponibilizarQuarto(1L);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void shouldReturnErrorWhenQuartoDoesNotExist() {
        when(indisponibilizarQuartoUseCase.executar(1L)).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> {
            indisponibilizarQuartoController.indisponibilizarQuarto(1L);
        });
    }
}