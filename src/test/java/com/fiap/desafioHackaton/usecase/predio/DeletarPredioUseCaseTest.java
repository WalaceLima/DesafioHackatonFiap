package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarPredioUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private DeletarPredioUseCase deletarPredioUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarPredioUseCase = new DeletarPredioUseCase(predioGateway);
    }

    @Test
    public void shouldDeleteBuildingWhenIdExists() {
        Predio predio = new Predio();
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.of(predio));

        assertDoesNotThrow(() -> deletarPredioUseCase.executar(1L));
        verify(predioGateway, times(1)).deletar(predio);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deletarPredioUseCase.executar(1L));
    }
}