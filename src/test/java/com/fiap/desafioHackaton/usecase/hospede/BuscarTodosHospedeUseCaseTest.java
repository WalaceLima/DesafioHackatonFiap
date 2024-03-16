package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class BuscarTodosHospedeUseCaseTest {

    private HospedeGateway hospedeGateway;
    private BuscarTodosHospedeUseCase buscarTodosHospedeUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        buscarTodosHospedeUseCase = new BuscarTodosHospedeUseCase(hospedeGateway);
    }

    @Test
    public void testExecuteReturnsAllClientes() {
        // Arrange
        Hospede hospede1 = new Hospede();
        Hospede hospede2 = new Hospede();
        List<Hospede> hospedes = Arrays.asList(hospede1, hospede2);
        when(hospedeGateway.listar()).thenReturn(hospedes);

        // Act
        List<Hospede> result = buscarTodosHospedeUseCase.execute();

        // Assert
        assertNotNull(result);
        assertEquals(hospedes, result);
    }
}
