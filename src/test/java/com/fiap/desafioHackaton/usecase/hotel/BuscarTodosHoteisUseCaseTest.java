package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class BuscarTodosHoteisUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    private BuscarTodosHoteisUseCase buscarTodosHoteisUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosHoteisUseCase = new BuscarTodosHoteisUseCase(hotelGateway);
    }

    @Test
    public void shouldReturnAllHotelsWhenTheyExist() {
        List<Hotel> expectedHotels = Collections.singletonList(new Hotel());
        when(hotelGateway.listar()).thenReturn(expectedHotels);

        List<Hotel> result = buscarTodosHoteisUseCase.executar();

        assertEquals(expectedHotels, result);
    }

    @Test
    public void shouldReturnEmptyListWhenNoHotelsExist() {
        when(hotelGateway.listar()).thenReturn(Collections.emptyList());

        List<Hotel> result = buscarTodosHoteisUseCase.executar();

        assertTrue(result.isEmpty());
    }
}