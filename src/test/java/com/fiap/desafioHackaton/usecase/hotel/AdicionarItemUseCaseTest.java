package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.usecase.item.BuscarItemUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdicionarItemUseCaseTest {


    private HotelGateway hotelGateway;
    private BuscarItemUseCase buscarItemUseCase;
    private AdicionarItemUseCase adicionarItemUseCase;

    @BeforeEach
    void setUp() {
        hotelGateway = Mockito.mock(HotelGateway.class);
        buscarItemUseCase = Mockito.mock(BuscarItemUseCase.class);
        adicionarItemUseCase = new AdicionarItemUseCase(hotelGateway, buscarItemUseCase);
    }


    @Test
    void testExecutar() {
        Long hotelId = 1L;
        Long itemId = 1L;
        Hotel mockHotel = new Hotel(hotelId, "Hotel Teste", null);
        Item mockItem = new Item(itemId, "Item Teste", new BigDecimal("10.00"));

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.of(mockHotel));
        when(buscarItemUseCase.execute(itemId)).thenReturn(mockItem);
        when(hotelGateway.adicionarItem(any(Hotel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Hotel result = adicionarItemUseCase.executar(hotelId, itemId);

        assertEquals(1, result.getItensDiponiveis().size());
        assertEquals(mockItem, result.getItensDiponiveis().get(0));

        verify(hotelGateway, times(1)).buscarPorId(hotelId);
        verify(buscarItemUseCase, times(1)).execute(itemId);
        verify(hotelGateway, times(1)).adicionarItem(any(Hotel.class));
    }
}