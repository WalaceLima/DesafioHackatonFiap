package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfJaCadastradoException;
import com.fiap.desafioHackaton.domain.hospede.exception.CpfObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.exception.PassaporteObrigatorioException;
import com.fiap.desafioHackaton.domain.hospede.gateway.HospedeGateway;
import com.fiap.desafioHackaton.usecase.hospede.dto.IHospedeRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CriarHospedeUseCaseTest {

    private HospedeGateway hospedeGateway;
    private CriarHospedeUseCase criarHospedeUseCase;

    @BeforeEach
    public void setUp() {
        hospedeGateway = Mockito.mock(HospedeGateway.class);
        criarHospedeUseCase = new CriarHospedeUseCase(hospedeGateway);
    }

    @Test
    public void testExecutarReturnsCliente() {
        // Arrange
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Hospede hospede = new Hospede();
        when(hospedeGateway.criar(Mockito.any(Hospede.class))).thenReturn(hospede);

        // Act
        Hospede result = criarHospedeUseCase.executar(dados);

        // Assert
        assertNotNull(result);
        assertEquals(hospede, result);
    }

    @Test
    public void testExecutarThrowsCpfObrigatorioException() {
        // Arrange
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn(null);

        // Act & Assert
        assertThrows(CpfObrigatorioException.class, () -> criarHospedeUseCase.executar(dados));
    }

    @Test
    public void testExecutarThrowsPassaporteObrigatorioException() {
        // Arrange
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("USA");
        when(dados.passaporte()).thenReturn(null);

        // Act & Assert
        assertThrows(PassaporteObrigatorioException.class, () -> criarHospedeUseCase.executar(dados));
    }

    @Test
    public void testExecutarThrowsCpfJaCadastradoException() {
        // Arrange
        IHospedeRequestData dados = Mockito.mock(IHospedeRequestData.class);
        when(dados.paisOrigem()).thenReturn("Brasil");
        when(dados.cpf()).thenReturn("12345678901");
        Hospede hospede = new Hospede();
        when(hospedeGateway.buscarPorCpf(dados.cpf())).thenReturn(Optional.of(hospede));

        // Act & Assert
        assertThrows(CpfJaCadastradoException.class, () -> criarHospedeUseCase.executar(dados));
    }
}
