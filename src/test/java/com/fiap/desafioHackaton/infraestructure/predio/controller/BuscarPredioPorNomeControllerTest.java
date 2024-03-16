package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.desafioHackaton.usecase.predio.BuscarPredioPorNomeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarPredioPorNomeControllerTest {

    private BuscarPredioPorNomeUseCase buscarPredioPorNomeUseCase;
    private BuscarPredioPorNomeController controller;

    @BeforeEach
    public void setUp() {
        buscarPredioPorNomeUseCase = Mockito.mock(BuscarPredioPorNomeUseCase.class);
        controller = new BuscarPredioPorNomeController(buscarPredioPorNomeUseCase);
    }

    @Test
    public void shouldReturnBuildingsWhenNameExists() {
        Predio predio1 = mock(Predio.class);
        Predio predio2 = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio1.getHotel()).thenReturn(hotel);
        when(predio2.getHotel()).thenReturn(hotel);
        List<Predio> predios = Arrays.asList(predio1, predio2);
        when(buscarPredioPorNomeUseCase.execute("test")).thenReturn(predios);

        ResponseEntity<List<PredioPublicData>> responseEntity = controller.buscarPredioPorNome("test");

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void shouldReturnEmptyListWhenNameDoesNotExist() {
        when(buscarPredioPorNomeUseCase.execute("test")).thenReturn(Arrays.asList());

        ResponseEntity<List<PredioPublicData>> responseEntity = controller.buscarPredioPorNome("test");

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}