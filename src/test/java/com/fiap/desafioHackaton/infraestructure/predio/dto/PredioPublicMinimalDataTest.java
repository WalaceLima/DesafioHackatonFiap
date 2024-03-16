package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PredioPublicMinimalDataTest {

    @Test
    public void shouldCreatePredioPublicMinimalDataFromPredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Collections.emptyList());

        PredioPublicMinimalData predioPublicMinimalData = new PredioPublicMinimalData(predio);

        assertEquals(1L, predioPublicMinimalData.id());
        assertEquals("Test Name", predioPublicMinimalData.nome());
        assertEquals(0, predioPublicMinimalData.quartos().size());
    }

    @Test
    public void shouldHandleEmptyQuartosInPredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Collections.emptyList());

        PredioPublicMinimalData predioPublicMinimalData = new PredioPublicMinimalData(predio);

        assertEquals(1L, predioPublicMinimalData.id());
        assertEquals("Test Name", predioPublicMinimalData.nome());
        assertEquals(0, predioPublicMinimalData.quartos().size());
    }

    @Test
    public void shouldHandleNullQuartosInPredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Collections.emptyList());

        PredioPublicMinimalData predioPublicMinimalData = new PredioPublicMinimalData(predio);

        assertEquals(1L, predioPublicMinimalData.id());
        assertEquals("Test Name", predioPublicMinimalData.nome());
        assertEquals(0, predioPublicMinimalData.quartos().size());
    }
}