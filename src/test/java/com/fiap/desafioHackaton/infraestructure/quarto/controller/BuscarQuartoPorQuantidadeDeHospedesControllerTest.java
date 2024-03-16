package com.fiap.desafioHackaton.infraestructure.quarto.controller;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSearchResponseData;
import com.fiap.desafioHackaton.usecase.quarto.usecases.BuscarQuartoPorQuantidadeDeHospedesUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarQuartoPorQuantidadeDeHospedesControllerTest {

    private final BuscarQuartoPorQuantidadeDeHospedesUseCase useCase = Mockito.mock(BuscarQuartoPorQuantidadeDeHospedesUseCase.class);
    private final BuscarQuartoPorQuantidadeDeHospedesController controller = new BuscarQuartoPorQuantidadeDeHospedesController(useCase);

    @Test
    public void shouldReturnQuartosWhenHospedesExist() {
        Quarto quarto = mock(Quarto.class);
        TipoQuarto tipoQuarto = mock(TipoQuarto.class);
        Predio predio = mock(Predio.class);

        when(quarto.getTipoQuarto()).thenReturn(tipoQuarto);
        when(quarto.getPredio()).thenReturn(predio);
        when(quarto.getIdHotel()).thenReturn(1L);
        when(quarto.getValorDiaria()).thenReturn(new BigDecimal(100.00));
        when(quarto.getStatus()).thenReturn(Status.DISPONIVEL);
        when(quarto.getId()).thenReturn(1L);
        when(tipoQuarto.getId()).thenReturn(1L);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Predio 1");

        when(useCase.execute(1L)).thenReturn(Collections.singletonList(quarto));

        ResponseEntity<List<QuartoSearchResponseData>> response = controller.buscarQuarto(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void shouldReturnEmptyListWhenNoHospedesExist() {
        when(useCase.execute(1L)).thenReturn(Collections.emptyList());

        ResponseEntity<List<QuartoSearchResponseData>> response = controller.buscarQuarto(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}