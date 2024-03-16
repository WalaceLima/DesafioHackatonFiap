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

public class BuscarHotelPorLogradouroUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarHotelPorLogradouroUseCase = new BuscarHotelPorLogradouroUseCase(hotelGateway);
    }

    @Test
    public void shouldReturnHotelsWhenLogradouroExists() {
        List<Hotel> expectedHotels = Collections.singletonList(new Hotel());
        when(hotelGateway.buscarPorLogradouro(anyString())).thenReturn(Optional.of(expectedHotels));

        List<Hotel> result = buscarHotelPorLogradouroUseCase.executar("Avenida Paulista");

        assertEquals(expectedHotels, result);
    }

    @Test
    public void shouldThrowExceptionWhenLogradouroDoesNotExist() {
        when(hotelGateway.buscarPorLogradouro(anyString())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> buscarHotelPorLogradouroUseCase.executar("Avenida Paulista"));
    }
}