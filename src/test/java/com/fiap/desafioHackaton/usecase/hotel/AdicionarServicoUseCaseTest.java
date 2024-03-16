package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.usecase.servico.BuscarServicoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AdicionarServicoUseCaseTest {


    @Mock
    private HotelGateway hotelGateway;
    @Mock
    private BuscarServicoUseCase buscarServicoUseCase;

    private AdicionarServicoUseCase adicionarServicoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adicionarServicoUseCase = new AdicionarServicoUseCase(hotelGateway, buscarServicoUseCase);
    }

    @Test
    void adicionarServicoComSucesso() {
        Long hotelId = 1L;
        Long servicoId = 1L;
        Hotel hotel = mock(Hotel.class);
        Servico servico = mock(Servico.class);

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.of(hotel));
        when(buscarServicoUseCase.execute(servicoId)).thenReturn(servico);
        when(hotelGateway.adicionarServico(hotel)).thenReturn(hotel);

        Hotel resultado = adicionarServicoUseCase.executar(hotelId, servicoId);

        verify(hotel).addServico(servico);
        verify(hotelGateway).adicionarServico(hotel);
        assertEquals(hotel, resultado);
    }

    @Test
    void hotelNaoEncontrado() {
        Long hotelId = 1L;
        Long servicoId = 1L;

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> adicionarServicoUseCase.executar(hotelId, servicoId));

        verify(buscarServicoUseCase, never()).execute(servicoId);
        verify(hotelGateway, never()).adicionarServico(any());
    }

}