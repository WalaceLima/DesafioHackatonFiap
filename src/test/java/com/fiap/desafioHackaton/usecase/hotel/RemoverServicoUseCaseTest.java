package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.usecase.servico.BuscarServicoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

public class RemoverServicoUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    @Mock
    private BuscarServicoUseCase buscarServicoUseCase;

    private RemoverServicoUseCase removerServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        removerServicoUseCase = new RemoverServicoUseCase(hotelGateway, buscarServicoUseCase);
    }

    @Test
    public void shouldThrowExceptionWhenHotelDoesNotExist() {
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> removerServicoUseCase.executar(1L, 1L));
    }

    @Test
    public void shouldThrowExceptionWhenServiceDoesNotExist() {
        Hotel hotel = new Hotel();
        when(hotelGateway.buscarPorId(anyLong())).thenReturn(Optional.of(hotel));
        when(buscarServicoUseCase.execute(anyLong())).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> removerServicoUseCase.executar(1L, 1L));
    }
}