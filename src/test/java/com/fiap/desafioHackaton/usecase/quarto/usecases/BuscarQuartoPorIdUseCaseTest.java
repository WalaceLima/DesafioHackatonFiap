package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BuscarQuartoPorIdUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;

    private BuscarQuartoPorIdUseCase buscarQuartoPorIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarQuartoPorIdUseCase = new BuscarQuartoPorIdUseCase(quartoGateway);
    }

    @Test
    public void shouldReturnRoomWhenIdExists() {
        Quarto quarto = new Quarto();
        when(quartoGateway.buscarPorId(1L)).thenReturn(Optional.of(quarto));

        Quarto result = buscarQuartoPorIdUseCase.execute(1L);

        assertEquals(quarto, result);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(quartoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarQuartoPorIdUseCase.execute(1L));
    }
}