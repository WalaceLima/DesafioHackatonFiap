package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import com.fiap.desafioHackaton.usecase.quarto.dto.IQuartoRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CriarQuartoUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;
    @Mock
    private PredioGateway predioGateway;
    @Mock
    private TipoQuartoGateway tipoQuartoGateway;
    @Mock
    private IQuartoRequestData dados;

    private CriarQuartoUseCase criarQuartoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        criarQuartoUseCase = new CriarQuartoUseCase(quartoGateway, predioGateway, tipoQuartoGateway);
    }

    @Test
    void deveCriarQuartoComSucesso() {
        Long predioId = 1L;
        Long tipoQuartoId = 2L;
        BigDecimal valorDiaria = new BigDecimal("200.00");
        String status = "DISPONIVEL";

        Predio predioMock = mock(Predio.class);
        TipoQuarto tipoQuartoMock = mock(TipoQuarto.class);

        when(dados.idPredio()).thenReturn(predioId);
        when(dados.idTipoQuarto()).thenReturn(tipoQuartoId);
        when(dados.valorDiaria()).thenReturn(valorDiaria);
        when(dados.status()).thenReturn(status);

        when(predioGateway.buscarPorId(predioId)).thenReturn(Optional.of(predioMock));
        when(tipoQuartoGateway.buscarPorId(tipoQuartoId)).thenReturn(tipoQuartoMock);

        Quarto quartoCriado = new Quarto(predioMock, tipoQuartoMock, Status.valueOf(status), valorDiaria);
        when(quartoGateway.criar(any(Quarto.class))).thenReturn(quartoCriado);

        Quarto resultado = criarQuartoUseCase.executar(dados);

        assertNotNull(resultado);
        assertEquals(Status.DISPONIVEL, resultado.getStatus());
        assertEquals(valorDiaria, resultado.getValorDiaria());
        assertEquals(predioMock, resultado.getPredio());
        assertEquals(tipoQuartoMock, resultado.getTipoQuarto());

        verify(quartoGateway).criar(any(Quarto.class));
    }

}
