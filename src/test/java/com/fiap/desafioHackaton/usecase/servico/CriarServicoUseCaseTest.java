package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import com.fiap.desafioHackaton.usecase.servico.dto.IServicoRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CriarServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    @Mock
    private IServicoRequestData dados;

    private CriarServicoUseCase criarServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        criarServicoUseCase = new CriarServicoUseCase(servicoGateway);
    }

    @Test
    public void testExecutar() {
        Servico servico = new Servico("Teste", new BigDecimal(100.0));
        when(dados.nome()).thenReturn("Teste");
        when(dados.valor()).thenReturn(new BigDecimal(100.0));
        when(servicoGateway.criar(any(Servico.class))).thenReturn(servico);

        Servico result = criarServicoUseCase.executar(dados);

        assertEquals(servico, result);
        verify(servicoGateway, times(1)).criar(any(Servico.class));
    }
}