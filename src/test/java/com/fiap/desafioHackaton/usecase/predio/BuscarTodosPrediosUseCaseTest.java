package com.fiap.desafioHackaton.usecase.predio;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.exception.PredioNaoEncontradoException;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BuscarTodosPrediosUseCaseTest {

    @Mock
    private PredioGateway predioGateway;

    private BuscarTodosPrediosUseCase buscarTodosPrediosUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosPrediosUseCase = new BuscarTodosPrediosUseCase(predioGateway);
    }

    @Test
    public void shouldReturnAllBuildingsWhenTheyExist() {
        List<Predio> predios = Collections.singletonList(new Predio());
        when(predioGateway.listar()).thenReturn(predios);

        List<Predio> result = buscarTodosPrediosUseCase.executar();

        assertEquals(predios, result);
    }

    @Test
    public void shouldThrowExceptionWhenNoBuildingsExist() {
        when(predioGateway.listar()).thenReturn(Collections.emptyList());

        assertThrows(PredioNaoEncontradoException.class, () -> buscarTodosPrediosUseCase.executar());
    }
}