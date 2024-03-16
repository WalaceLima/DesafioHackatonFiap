package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.usecase.predio.DeletarPredioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class RemoverPredioUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    @Mock
    private DeletarPredioUseCase deletarPredioUseCase;

    private RemoverPredioUseCase removerPredioUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        removerPredioUseCase = new RemoverPredioUseCase(hotelGateway, deletarPredioUseCase);
    }

    @Test
    public void shouldRemoveBuildingWhenHotelAndBuildingExist() {
        Hotel hotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));

        Hotel result = removerPredioUseCase.executar(1L, 1L);

        assertEquals(hotel, result);
        verify(deletarPredioUseCase, times(1)).executar(1L);
    }

    @Test
    public void shouldThrowExceptionWhenHotelDoesNotExist() {
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> removerPredioUseCase.executar(1L, 1L));
    }

    @Test
    public void shouldThrowExceptionWhenBuildingDeletionFails() {
        Hotel hotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));
        doThrow(RuntimeException.class).when(deletarPredioUseCase).executar(anyLong());

        assertThrows(RuntimeException.class, () -> removerPredioUseCase.executar(1L, 1L));
    }
}