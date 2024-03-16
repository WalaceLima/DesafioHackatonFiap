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

public class BuscarHotelPorNomeUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarHotelPorNomeUseCase = new BuscarHotelPorNomeUseCase(hotelGateway);
    }

    @Test
    public void shouldReturnHotelsWhenNameExists() {
        List<Hotel> expectedHotels = Collections.singletonList(new Hotel());
        when(hotelGateway.buscarPorNome(anyString())).thenReturn(Optional.of(expectedHotels));

        List<Hotel> result = buscarHotelPorNomeUseCase.executar("Hotel Test");

        assertEquals(expectedHotels, result);
    }

    @Test
    public void shouldThrowExceptionWhenNameDoesNotExist() {
        when(hotelGateway.buscarPorNome(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarHotelPorNomeUseCase.executar("Hotel Test"));
    }
}