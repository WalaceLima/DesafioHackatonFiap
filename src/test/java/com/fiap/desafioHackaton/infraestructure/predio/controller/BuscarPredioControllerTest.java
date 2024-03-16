package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.desafioHackaton.usecase.predio.BuscarPredioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarPredioControllerTest {

    private BuscarPredioUseCase buscarPredioUseCase;
    private BuscarPredioController controller;

    @BeforeEach
    public void setUp() {
        buscarPredioUseCase = Mockito.mock(BuscarPredioUseCase.class);
        controller = new BuscarPredioController(buscarPredioUseCase);
    }

    @Test
    public void shouldReturnBuildingWhenBuildingExists() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio.getHotel()).thenReturn(hotel);
        when(buscarPredioUseCase.executar(1L)).thenReturn(predio);

        ResponseEntity<PredioPublicData> responseEntity = controller.buscarPredio(1L);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(new PredioPublicData(predio), responseEntity.getBody());
    }

}