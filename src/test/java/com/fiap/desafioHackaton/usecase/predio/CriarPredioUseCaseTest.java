package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CriarPredioUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private CriarPredioUseCase criarPredioUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        criarPredioUseCase = new CriarPredioUseCase(predioGateway);
    }

    @Test
    public void shouldCreateBuildingWhenDataIsValid() {
        Predio predio = new Predio();
        when(predioGateway.criar(any(Predio.class))).thenReturn(predio);

        Predio result = criarPredioUseCase.executar(predio);

        assertEquals(predio, result);
        verify(predioGateway, times(1)).criar(predio);
    }

    @Test
    public void shouldThrowExceptionWhenDataIsNull() {
        doThrow(NullPointerException.class).when(predioGateway).criar(null);

        assertThrows(NullPointerException.class, () -> criarPredioUseCase.executar(null));
    }
}