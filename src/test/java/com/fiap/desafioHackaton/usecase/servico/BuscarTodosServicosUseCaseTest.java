package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.exception.ServicoNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarTodosServicosUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    private BuscarTodosServicosUseCase buscarTodosServicosUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosServicosUseCase = new BuscarTodosServicosUseCase(servicoGateway);
    }

    @Test
    public void shouldReturnAllServicesWhenServicesExist() {
        Servico servico = new Servico();
        List<Servico> servicos = Collections.singletonList(servico);
        when(servicoGateway.listar()).thenReturn(servicos);

        List<Servico> result = buscarTodosServicosUseCase.execute();

        assertEquals(servicos, result);
    }

    @Test
    public void shouldThrowExceptionWhenNoServicesExist() {
        when(servicoGateway.listar()).thenReturn(Collections.emptyList());

        assertThrows(ServicoNaoEncontradoException.class, () -> buscarTodosServicosUseCase.execute());
    }
}