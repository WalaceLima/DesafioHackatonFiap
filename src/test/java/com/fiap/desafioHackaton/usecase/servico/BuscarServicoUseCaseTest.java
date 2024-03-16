package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.exception.ServicoNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    private BuscarServicoUseCase buscarServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarServicoUseCase = new BuscarServicoUseCase(servicoGateway);
    }

    @Test
    public void shouldReturnServiceWhenServiceExists() {
        Servico servico = new Servico();
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.of(servico));

        Servico result = buscarServicoUseCase.execute(1L);

        assertEquals(servico, result);
    }

    @Test
    public void shouldThrowExceptionWhenServiceDoesNotExist() {
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(ServicoNaoEncontradoException.class, () -> buscarServicoUseCase.execute(1L));
    }
}