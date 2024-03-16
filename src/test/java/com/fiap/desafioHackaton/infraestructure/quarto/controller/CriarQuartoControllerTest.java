package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.CriarQuartoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriarQuartoControllerTest {

    @Mock
    private CriarQuartoUseCase criarQuartoUseCase;

    @InjectMocks
    private CriarQuartoController criarQuartoController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldCreateQuartoSuccessfully() {
        Quarto quarto = mock(Quarto.class);
        Predio predioMock = mock(Predio.class);
        QuartoRequestData dados = mock(QuartoRequestData.class);
        when(predioMock.getId()).thenReturn(1L);
        when(quarto.getPredio()).thenReturn(predioMock);
        when(criarQuartoUseCase.executar(dados)).thenReturn(quarto);

        ResponseEntity<QuartoPublicData> response = criarQuartoController.criarQuarto(dados);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenQuartoDataIsInvalid() {
        QuartoRequestData dados = mock(QuartoRequestData.class);
        when(criarQuartoUseCase.executar(dados)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class, () -> {
            criarQuartoController.criarQuarto(dados);
        });
    }
}