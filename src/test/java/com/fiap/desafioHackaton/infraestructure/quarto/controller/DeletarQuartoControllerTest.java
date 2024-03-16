package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.usecase.quarto.usecases.DeletarQuartoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DeletarQuartoControllerTest {

    @Mock
    private DeletarQuartoUseCase deletarQuartoUseCase;

    @InjectMocks
    private DeletarQuartoController deletarQuartoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldDeleteQuartoSuccessfully() {
        doNothing().when(deletarQuartoUseCase).executar(1L);

        ResponseEntity<Void> response = deletarQuartoController.deletarQuarto(1L);

        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void shouldReturnErrorWhenQuartoDoesNotExist() {
        doThrow(new RuntimeException()).when(deletarQuartoUseCase).executar(1L);

        assertThrows(RuntimeException.class, () -> {
            deletarQuartoController.deletarQuarto(1L);
        });
    }
}