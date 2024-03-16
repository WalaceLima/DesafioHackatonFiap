package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedeRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class AtualizarHospedeUseCaseTest {

    private HospedeGateway hospedeGateway;
    private AtualizarHospedeeUseCase atualizarHospedeeUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        atualizarHospedeeUseCase = new AtualizarHospedeeUseCase(hospedeGateway);
    }

    @Test
    public void testExecuteReturnsUpdatedCliente() {
        // Arrange
        Long id = 1L;
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Hospede hospedeOriginal = new Hospede();
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.of(hospedeOriginal));
        Hospede hospedeAtualizado = new Hospede();
        when(hospedeGateway.atualizar(Mockito.any(Hospede.class))).thenReturn(hospedeAtualizado);

        // Act
        Hospede result = atualizarHospedeeUseCase.execute(id, dados);

        // Assert
        assertNotNull(result);
        assertEquals(hospedeAtualizado, result);
    }

    @Test
    public void testExecuteThrowsNoSuchElementException() {
        // Arrange
        Long id = 1L;
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> atualizarHospedeeUseCase.execute(id, dados));
    }

    @Test
    public void testExecuteThrowsCpfObrigatorioException() {
        // Arrange
        Long id = 1L;
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn(null);
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.of(new Hospede()));

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> atualizarHospedeeUseCase.execute(id, dados));
    }

    @Test
    public void testExecuteThrowsPassaporteObrigatorioException() {
        // Arrange
        Long id = 1L;
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("USA");
        when(dados.passaporte()).thenReturn(null);
        when(hospedeGateway.buscarPorId(id)).thenReturn(Optional.of(new Hospede()));

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> atualizarHospedeeUseCase.execute(id, dados));
    }
}
