package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class BuscarPredioPorNomeUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarPredioPorNomeUseCase = new BuscarPredioPorNomeUseCase(predioGateway);
    }

    @Test
    public void shouldReturnBuildingWhenNameExists() {
        List<Predio> predios = Collections.singletonList(new Predio());
        when(predioGateway.buscarPorNome(anyString())).thenReturn(Optional.of(predios));

        List<Predio> result = buscarPredioPorNomeUseCase.execute("Test Name");

        assertEquals(predios, result);
    }

    @Test
    public void shouldThrowExceptionWhenNameDoesNotExist() {
        when(predioGateway.buscarPorNome(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarPredioPorNomeUseCase.execute("Test Name"));
    }
}