package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoRequestData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.AtualizarQuartoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AtualizarQuartoControllerTest {

    @Mock
    private AtualizarQuartoUseCase atualizarQuartoUseCase;

    @InjectMocks
    private AtualizarQuartoController atualizarQuartoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void atualizarQuartoReturnsQuartoPublicDataWhenDataIsValid() {
        Long id = 1L;
        QuartoRequestData requestData = new QuartoRequestData(1L, 1L, "DISPONIVEL", new BigDecimal("100.00"));
        Quarto quarto = new Quarto();
        when(atualizarQuartoUseCase.execute(eq(id), any(QuartoRequestData.class))).thenReturn(quarto);

        ResponseEntity<QuartoPublicData> response = atualizarQuartoController.atualizarQuarto(id, requestData);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        verify(atualizarQuartoUseCase).execute(eq(id), any(QuartoRequestData.class));
    }

}