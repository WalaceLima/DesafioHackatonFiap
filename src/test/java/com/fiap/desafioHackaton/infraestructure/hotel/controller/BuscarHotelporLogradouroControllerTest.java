package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorLogradouroUseCase;
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

public class BuscarHotelporLogradouroControllerTest {

    private BuscarHotelPorLogradouroUseCase buscarHotelPorLogradouroUseCase;
    private BuscarHotelporLogradouroController controller;

    @BeforeEach
    public void setUp() {
        buscarHotelPorLogradouroUseCase = Mockito.mock(BuscarHotelPorLogradouroUseCase.class);
        controller = new BuscarHotelporLogradouroController(buscarHotelPorLogradouroUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelsWhenLogradouroIsValid() {
        Hotel hotel = new Hotel();
        when(buscarHotelPorLogradouroUseCase.executar("Rua A")).thenReturn(Collections.singletonList(hotel));

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarHotelPorLogradouro("Rua A");

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnEmptyListWhenNoHotelsFoundForLogradouro() {
        when(buscarHotelPorLogradouroUseCase.executar("Rua A")).thenReturn(Collections.emptyList());

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarHotelPorLogradouro("Rua A");

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}