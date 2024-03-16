package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

public class BuscarHotelPorIdUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private BuscarHotelPorIdUseCase buscarHotelPorIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarHotelPorIdUseCase = new BuscarHotelPorIdUseCase(hotelGateway);
    }

    @Test
    public void shouldReturnHotelWhenIdExists() {
        Hotel expectedHotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(expectedHotel));

        Hotel result = buscarHotelPorIdUseCase.buscarPorId(1L);

        assertEquals(expectedHotel, result);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarHotelPorIdUseCase.buscarPorId(1L));
    }
}