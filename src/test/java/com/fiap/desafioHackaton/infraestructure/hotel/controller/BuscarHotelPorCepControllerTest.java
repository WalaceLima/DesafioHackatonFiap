package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorCEPUseCase;
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

public class BuscarHotelPorCepControllerTest {

    private BuscarHotelPorCEPUseCase buscarHotelPorCEPUseCase;
    private BuscarHotelPorCepController controller;

    @BeforeEach
    public void setUp() {
        buscarHotelPorCEPUseCase = Mockito.mock(BuscarHotelPorCEPUseCase.class);
        controller = new BuscarHotelPorCepController(buscarHotelPorCEPUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelsWhenCepIsValid() {
        Hotel hotel = new Hotel();
        when(buscarHotelPorCEPUseCase.executar("12345678")).thenReturn(Collections.singletonList(hotel));

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarHotelPorCep("12345678");

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnEmptyListWhenNoHotelsFoundForCep() {
        when(buscarHotelPorCEPUseCase.executar("12345678")).thenReturn(Collections.emptyList());

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarHotelPorCep("12345678");

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}