package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.desafioHackaton.usecase.item.dto.IItemRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CriarItemUseCaseTest {

    @Mock
    private ItemGateway itemGateway;

    @Mock
    private IItemRequestData itemRequestData;

    private CriarItemUseCase criarItemUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        criarItemUseCase = new CriarItemUseCase(itemGateway);
    }

    @Test
    public void shouldCreateItemWhenDataIsValid() {
        Item item = new Item("Test Item", new BigDecimal(100.0));
        when(itemRequestData.nome()).thenReturn("Test Item");
        when(itemRequestData.valor()).thenReturn(new BigDecimal(100.0));
        when(itemGateway.criar(any(Item.class))).thenReturn(item);

        Item result = criarItemUseCase.executar(itemRequestData);

        assertEquals(item, result);
        verify(itemGateway, times(1)).criar(item);
    }

    @Test
    public void shouldThrowExceptionWhenDataIsInvalid() {
        when(itemRequestData.nome()).thenReturn("");
        when(itemRequestData.valor()).thenReturn(new BigDecimal(-1.0));

        assertThrows(IllegalArgumentException.class, () -> criarItemUseCase.executar(itemRequestData));
    }
}