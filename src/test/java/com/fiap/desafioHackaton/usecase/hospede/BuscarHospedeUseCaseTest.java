package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BuscarHospedeUseCaseTest {

    private HospedeGateway hospedeGateway;
    private BuscarClienteUseCase buscarClienteUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        buscarClienteUseCase = new BuscarClienteUseCase(hospedeGateway);
    }

    @Test
    public void testExecuteReturnsCliente() {
        // Arrange
        Long id = 1L;
        Hospede hospede = new Hospede();
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.of(hospede));

        // Act
        Hospede result = buscarClienteUseCase.execute(id);

        // Assert
        assertNotNull(result);
        assertEquals(hospede, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> buscarClienteUseCase.execute(id));
    }
}
