package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCompletePublicData;
import com.fiap.desafioHackaton.usecase.hotel.BuscarHotelPorIdUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BuscarHotelPorIdControllerTest {

    private BuscarHotelPorIdUseCase buscarHotelPorIdUseCase;
    private BuscarHotelPorIdController controller;

    @BeforeEach
    public void setUp() {
        buscarHotelPorIdUseCase = Mockito.mock(BuscarHotelPorIdUseCase.class);
        controller = new BuscarHotelPorIdController(buscarHotelPorIdUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelWhenIdIsValid() {
        Hotel hotel = new Hotel();
        when(buscarHotelPorIdUseCase.buscarPorId(1L)).thenReturn(hotel);

        ResponseEntity<HotelCompletePublicData> responseEntity = controller.buscarHotelPorId(1L);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnNotFoundWhenHotelDoesNotExist() {

        when(buscarHotelPorIdUseCase.buscarPorId(1L)).thenReturn(null);

        ResponseEntity<HotelCompletePublicData> responseEntity = controller.buscarHotelPorId(1L);

        assertEquals(404, responseEntity.getStatusCodeValue());
    }
}