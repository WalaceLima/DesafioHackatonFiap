package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarHospedeUseCaseTest {

    private HospedeGateway hospedeGateway;

    @Mock
    private ReservaGateway reservaGateway;
    private DeletarHospedeUseCase deletarHospedeUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        deletarHospedeUseCase = new DeletarHospedeUseCase(hospedeGateway, reservaGateway);
    }

    @Test
    public void testExecuteDeletesCliente() {
        // Arrange
        Long id = 1L;
        Hospede hospede = new Hospede();
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.of(hospede));

        // Act
        deletarHospedeUseCase.execute(id);

        // Assert
        verify(hospedeGateway, times(1)).deletar(hospede);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> deletarHospedeUseCase.execute(id));
    }
}
