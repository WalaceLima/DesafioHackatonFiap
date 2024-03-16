package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
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

class AtualizarQuartoUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;

    @Mock
    private PredioGateway predioGateway;

    @Mock
    private TipoQuartoGateway tipoQuartoGateway;

    @Mock
    private IQuartoRequestData dados;

    private AtualizarQuartoUseCase atualizarQuartoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        atualizarQuartoUseCase = new AtualizarQuartoUseCase(quartoGateway, predioGateway, tipoQuartoGateway);
    }

    @Test
    void deveAtualizarQuartoComSucesso() {
        Long quartoId = 1L;
        Long predioId = 1L;
        Long tipoQuartoId = 1L;
        String status = Status.DISPONIVEL.toString();
        BigDecimal valorDiaria = BigDecimal.valueOf(100.0);

        Quarto quartoMock = mock(Quarto.class);
        Predio predioMock = mock(Predio.class);
        Hotel hotelMock = mock(Hotel.class);
        TipoQuarto tipoQuartoMock = mock(TipoQuarto.class);

        when(quartoGateway.buscarPorId(quartoId)).thenReturn(Optional.of(quartoMock));
        when(predioGateway.buscarPorId(predioId)).thenReturn(Optional.of(predioMock));
        when(predioMock.getHotel()).thenReturn(hotelMock);
        when(tipoQuartoGateway.buscarPorId(tipoQuartoId)).thenReturn(tipoQuartoMock);
        when(dados.idPredio()).thenReturn(predioId);
        when(dados.idTipoQuarto()).thenReturn(tipoQuartoId);
        when(dados.status()).thenReturn(status);
        when(dados.valorDiaria()).thenReturn(valorDiaria);
        when(quartoGateway.atualizar(any())).thenAnswer(invocation -> invocation.getArgument(0));

        Quarto resultado = atualizarQuartoUseCase.execute(quartoId, dados);

        assertNotNull(resultado);
        verify(quartoMock).setTipoQuarto(tipoQuartoMock);
        verify(quartoMock).setPredio(predioMock);
        verify(quartoMock).setStatus(Status.valueOf(status));
        verify(quartoMock).setValorDiaria(valorDiaria);
    }
}