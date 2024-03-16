package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.usecase.hotel.dto.IHotelAtualizarRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class AtualizarHotelUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    @InjectMocks
    private AtualizarHotelUseCase atualizarHotelUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecutar() {
        // Arrange
        Hotel hotel = new Hotel();
        Long hotelId = 1L;
        IHotelAtualizarRequestData dados = mock(IHotelAtualizarRequestData.class);

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.of(hotel));
        when(hotelGateway.atualizar(any(Hotel.class))).thenReturn(hotel);

        // Act
        Hotel updatedHotel = atualizarHotelUseCase.executar(hotelId, dados);

        // Assert
        verify(hotelGateway, times(1)).buscarPorId(hotelId);
        verify(hotelGateway, times(1)).atualizar(any(Hotel.class));
    }

}