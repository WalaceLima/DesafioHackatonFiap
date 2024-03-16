package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AtualizarItemUseCaseTest {

    @Mock
    private ItemGateway itemGateway;

    private AtualizarItemUseCase atualizarItemUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        atualizarItemUseCase = new AtualizarItemUseCase(itemGateway);
    }

    @Test
    public void shouldUpdateItemWhenIdExistsAndDataIsValid() {
        Item item = new Item();
        ItemRequestData dados = new ItemRequestData("Test Item", new BigDecimal(100.0));
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.of(item));
        when(itemGateway.atualizar(any(Item.class))).thenReturn(item);

        Item result = atualizarItemUseCase.execute(1L, dados);

        assertEquals(item, result);
        verify(itemGateway, times(1)).atualizar(item);
    }

    @Test
    public void shouldThrowExceptionWhenIdDoesNotExist() {
        ItemRequestData dados = new ItemRequestData("Test Item", new BigDecimal(100.0));
        when(itemGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> atualizarItemUseCase.execute(1L, dados));
    }
}