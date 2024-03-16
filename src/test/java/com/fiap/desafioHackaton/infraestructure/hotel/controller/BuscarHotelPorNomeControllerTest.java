package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorNomeUseCase;
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

public class BuscarHotelPorNomeControllerTest {

    private BuscarHotelPorNomeUseCase buscarHotelPorNomeUseCase;
    private BuscarHotelPorNomeController controller;

    @BeforeEach
    public void setUp() {
        buscarHotelPorNomeUseCase = Mockito.mock(BuscarHotelPorNomeUseCase.class);
        controller = new BuscarHotelPorNomeController(buscarHotelPorNomeUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelsWhenNameIsValid() {
        Hotel hotel = new Hotel();
        when(buscarHotelPorNomeUseCase.executar("Hotel A")).thenReturn(Collections.singletonList(hotel));

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarTodosOsHoteisPorNome("Hotel A");

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnEmptyListWhenNoHotelsFoundForName() {
        when(buscarHotelPorNomeUseCase.executar("Hotel A")).thenReturn(Collections.emptyList());

        ResponseEntity<List<HotelCompletePublicData>> responseEntity = controller.buscarTodosOsHoteisPorNome("Hotel A");

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals(0, responseEntity.getBody().size());
    }
}