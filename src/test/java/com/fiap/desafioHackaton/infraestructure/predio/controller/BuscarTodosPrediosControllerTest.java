package com.fiap.desafioHackaton.infraestructure.predio.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicData;
import com.fiap.desafioHackaton.usecase.predio.BuscarTodosPrediosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuscarTodosPrediosControllerTest {

    private BuscarTodosPrediosUseCase buscarTodosPrediosUseCase;
    private BuscarTodosPrediosController controller;

    @BeforeEach
    public void setUp() {
        buscarTodosPrediosUseCase = Mockito.mock(BuscarTodosPrediosUseCase.class);
        controller = new BuscarTodosPrediosController(buscarTodosPrediosUseCase);
    }

    @Test
    public void shouldReturnAllBuildingsWhenTheyExist() {
        Predio predio1 = mock(Predio.class);
        Predio predio2 = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        when(predio1.getHotel()).thenReturn(hotel);
        when(predio2.getHotel()).thenReturn(hotel);
        List<Predio> predios = Arrays.asList(predio1, predio2);
        when(buscarTodosPrediosUseCase.executar()).thenReturn(predios);

        ResponseEntity<List<PredioPublicData>> responseEntity = controller.buscarTodosPredios();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(2, responseEntity.getBody().size());
    }

    @Test
    public void shouldReturnEmptyListWhenNoBuildingsExist() {
        when(buscarTodosPrediosUseCase.executar()).thenReturn(Arrays.asList());

        ResponseEntity<List<PredioPublicData>> responseEntity = controller.buscarTodosPredios();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}