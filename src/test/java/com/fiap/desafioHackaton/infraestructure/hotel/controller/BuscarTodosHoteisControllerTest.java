package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarTodosHoteisUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarTodosHoteisControllerTest {

    private BuscarTodosHoteisUseCase buscarTodosHoteisUseCase;
    private BuscarTodosHoteisController controller;

    @BeforeEach
    public void setUp() {
        buscarTodosHoteisUseCase = Mockito.mock(BuscarTodosHoteisUseCase.class);
        controller = new BuscarTodosHoteisController(buscarTodosHoteisUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelsWhenHotelsExist() {
        Hotel hotel = new Hotel();
        when(buscarTodosHoteisUseCase.executar()).thenReturn(Collections.singletonList(hotel));

        ResponseEntity<List<HotelPublicData>> responseEntity = controller.buscarTodososHoteis();

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnEmptyListWhenNoHotelsExist() {
        when(buscarTodosHoteisUseCase.executar()).thenReturn(Collections.emptyList());

        ResponseEntity<List<HotelPublicData>> responseEntity = controller.buscarTodososHoteis();

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}