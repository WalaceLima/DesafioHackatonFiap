package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PredioPublicResponseAddDataTest {

    @Test
    public void shouldCreatePredioPublicResponseAddDataFromPredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Collections.emptyList());

        PredioPublicResponseAddData responseData = new PredioPublicResponseAddData(predio);

        assertEquals(1L, responseData.id());
        assertEquals("Test Name", responseData.nome());
    }

    @Test
    public void shouldHandleNullNameInPredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn(null);
        when(predio.getQuartos()).thenReturn(Collections.emptyList());

        PredioPublicResponseAddData responseData = new PredioPublicResponseAddData(predio);

        assertEquals(1L, responseData.id());
        assertEquals(null, responseData.nome());
    }
}