package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import com.fiap.desafioHackaton.usecase.predio.dto.IPredioUpdateData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AtualizarPredioUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    @Mock
    private IPredioUpdateData predioUpdateData;

    private AtualizarPredioUseCase atualizarPredioUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        atualizarPredioUseCase = new AtualizarPredioUseCase(predioGateway);
    }

    @Test
    public void shouldUpdateBuildingWhenIdExists() {
        Predio predio = new Predio();
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.of(predio));
        when(predioUpdateData.nome()).thenReturn("Updated Name");
        when(predioGateway.atualizar(any(Predio.class))).thenReturn(predio);

        Predio result = atualizarPredioUseCase.executar(1L, predioUpdateData);

        assertEquals(predio, result);
        verify(predioGateway, times(1)).atualizar(predio);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(predioGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> atualizarPredioUseCase.executar(1L, predioUpdateData));
    }
}