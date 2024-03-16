package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.exception.ItemNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

public class BuscarItemUseCaseTest {

    @Mock
    private ItemGateway itemGateway;

    private BuscarItemUseCase buscarItemUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarItemUseCase = new BuscarItemUseCase(itemGateway);
    }

    @Test
    public void shouldReturnItemWhenIdExists() {
        Item item = new Item();
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.of(item));

        Item result = buscarItemUseCase.execute(1L);

        assertEquals(item, result);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(ItemNaoEncontradoException.class, () -> buscarItemUseCase.execute(1L));
    }
}