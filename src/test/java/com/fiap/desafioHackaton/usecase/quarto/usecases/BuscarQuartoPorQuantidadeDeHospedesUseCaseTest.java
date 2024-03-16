package com.fiap.desafioHackaton.usecase.quarto.usecases;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.gateway.QuartoGateway;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.gateway.TipoQuartoGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarQuartoPorQuantidadeDeHospedesUseCaseTest {

    @Mock
    private QuartoGateway quartoGateway;

    @Mock
    private TipoQuartoGateway tipoQuartoGateway;

    private BuscarQuartoPorQuantidadeDeHospedesUseCase buscarQuartoPorQuantidadeDeHospedesUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        buscarQuartoPorQuantidadeDeHospedesUseCase = new BuscarQuartoPorQuantidadeDeHospedesUseCase(quartoGateway, tipoQuartoGateway);
    }

    @Test
    public void shouldReturnRoomsWhenGuestNumberIsValid() {
        TipoQuarto tipoQuarto = new TipoQuarto();
        Quarto quarto = new Quarto();
        when(tipoQuartoGateway.buscaTiposQuartoPorCapacidadeTotal(1L)).thenReturn(Arrays.asList(tipoQuarto));
        when(quartoGateway.buscarQuartoPorTipo(tipoQuarto)).thenReturn(Arrays.asList(quarto));

        List<Quarto> result = buscarQuartoPorQuantidadeDeHospedesUseCase.execute(1L);

        assertEquals(Arrays.asList(quarto), result);
    }

    @Test
    public void shouldReturnEmptyListWhenNoRoomsAvailable() {
        when(tipoQuartoGateway.buscaTiposQuartoPorCapacidadeTotal(1L)).thenReturn(Arrays.asList());

        List<Quarto> result = buscarQuartoPorQuantidadeDeHospedesUseCase.execute(1L);

        assertEquals(Arrays.asList(), result);
    }
}