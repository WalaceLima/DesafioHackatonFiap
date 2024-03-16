package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

public class BuscarPredioUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private BuscarPredioUseCase buscarPredioUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarPredioUseCase = new BuscarPredioUseCase(predioGateway);
    }

    @Test
    public void shouldReturnBuildingWhenIdExists() {
        Predio predio = new Predio();
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.of(predio));

        Predio result = buscarPredioUseCase.executar(1L);

        assertEquals(predio, result);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarPredioUseCase.executar(1L));
    }
}