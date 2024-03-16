package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AtualizarServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    private AtualizarServicoUseCase atualizarServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        atualizarServicoUseCase = new AtualizarServicoUseCase(servicoGateway);
    }

    @Test
    public void shouldUpdateServiceWhenDataIsValid() {
        Servico servico = new Servico();
        servico.setNome("Old Name");
        servico.setValor(BigDecimal.valueOf(100));

        ServicoRequestData dados = new ServicoRequestData("New Name", BigDecimal.valueOf(200));

        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.of(servico));
        when(servicoGateway.atualizar(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Servico result = atualizarServicoUseCase.execute(1L, dados);

        assertEquals("New Name", result.getNome());
        assertEquals(BigDecimal.valueOf(200), result.getValor());
    }

    @Test
    public void shouldThrowExceptionWhenServiceDoesNotExist() {
        ServicoRequestData dados = new ServicoRequestData("New Name", BigDecimal.valueOf(200));

        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> atualizarServicoUseCase.execute(1L, dados));
    }
}