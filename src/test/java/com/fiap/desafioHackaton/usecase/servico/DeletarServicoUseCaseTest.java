package com.fiap.desafioHackaton.usecase.servico;

import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.hotel.servico.gateway.ServicoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeletarServicoUseCaseTest {

    @Mock
    private ServicoGateway servicoGateway;

    @Mock
    private HotelGateway hotelGateway;
    private DeletarServicoUseCase deletarServicoUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deletarServicoUseCase = new DeletarServicoUseCase(servicoGateway, hotelGateway);
    }

    @Test
    public void shouldDeleteServiceWhenServiceExists() {
        Servico servico = new Servico();
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.of(servico));

        deletarServicoUseCase.execute(1L);

        verify(servicoGateway).deletar(servico);
    }

    @Test
    public void shouldThrowExceptionWhenServiceDoesNotExist() {
        when(servicoGateway.buscarPorId(1L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> deletarServicoUseCase.execute(1L));
    }
}
