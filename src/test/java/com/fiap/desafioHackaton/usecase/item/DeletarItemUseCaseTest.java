package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class DeletarItemUseCaseTest {

    @Mock
    private ItemGateway itemGateway;

    @Mock
    private HotelGateway hotelGateway;
    private DeletarItemUseCase deletarItemUseCase;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarItemUseCase = new DeletarItemUseCase(itemGateway, hotelGateway);
    }

    @Test
    public void shouldDeleteItemWhenIdExists() {
        Item item = new Item();
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.of(item));

        deletarItemUseCase.execute(1L);

        verify(itemGateway, times(1)).deletar(item);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> deletarItemUseCase.execute(1L));
    }
}
