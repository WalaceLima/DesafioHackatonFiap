package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class BuscarHotelPorCEPUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarHotelPorCEPUseCase = new BuscarHotelPorCEPUseCase(hotelGateway);
    }

    @Test
    public void shouldReturnHotelsWhenCepExists() {
        List<Hotel> expectedHotels = Collections.singletonList(new Hotel());
        when(hotelGateway.buscarPorCep(anyString())).thenReturn(Optional.of(expectedHotels));

        List<Hotel> result = buscarHotelPorCEPUseCase.executar("12345");

        assertEquals(expectedHotels, result);
    }

    @Test
    public void shouldThrowExceptionWhenCepDoesNotExist() {
        when(hotelGateway.buscarPorCep(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarHotelPorCEPUseCase.executar("12345"));
    }
}