package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.exception.ItemNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class BuscarTodosItensUseCaseTest {

    @Mock
    private ItemGateway itemGateway;

    private BuscarTodosItensUseCase buscarTodosItensUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarTodosItensUseCase = new BuscarTodosItensUseCase(itemGateway);
    }

    @Test
    public void shouldReturnAllItemsWhenItemsExist() {
        List<Item> items = Collections.singletonList(new Item());
        when(itemGateway.listar()).thenReturn(items);

        List<Item> result = buscarTodosItensUseCase.execute();

        assertEquals(items, result);
    }

    @Test
    public void shouldThrowExceptionWhenNoItemsExist() {
        when(itemGateway.listar()).thenReturn(Collections.emptyList());

        assertThrows(ItemNaoEncontradoException.class, () -> buscarTodosItensUseCase.execute());
    }
}