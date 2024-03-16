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

public class BuscarHospedePorCpfUseCaseTest {

    private HospedeGateway hospedeGateway;
    private BuscarHospedePorCpfUseCase buscarHospedePorCpfUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        buscarHospedePorCpfUseCase = new BuscarHospedePorCpfUseCase(hospedeGateway);
    }

    @Test
    public void testExecuteReturnsCliente() {
        // Arrange
        String cpf = "12345678901";
        Hospede hospede = new Hospede();
        when(hospedeGateway.buscarPorCpf(cpf)).thenReturn(Optional.of(hospede));

        // Act
        Hospede result = buscarHospedePorCpfUseCase.execute(cpf);

        // Assert
        assertNotNull(result);
        assertEquals(hospede, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        String cpf = "12345678901";
        when(hospedeGateway.buscarPorCpf(cpf)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> buscarHospedePorCpfUseCase.execute(cpf));
    }
}
