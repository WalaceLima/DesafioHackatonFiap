package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelAtualizarRequestData;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.usecase.hotel.AtualizarHotelUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtualizarHotelControllerTest {

    private AtualizarHotelUseCase atualizarHotelUseCase;
    private AtualizarHotelController controller;

    @BeforeEach
    public void setUp() {
        atualizarHotelUseCase = Mockito.mock(AtualizarHotelUseCase.class);
        controller = new AtualizarHotelController(atualizarHotelUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldUpdateHotelWhenDataIsValid() {
        HotelAtualizarRequestData requestData = mock(HotelAtualizarRequestData.class);
        Hotel hotel = mock(Hotel.class);
        when(atualizarHotelUseCase.executar(1L, requestData)).thenReturn(hotel);

        ResponseEntity<HotelPublicData> responseEntity = controller.atualizarHotel(1L, requestData);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenHotelDoesNotExist() {
        HotelAtualizarRequestData requestData = mock(HotelAtualizarRequestData.class);
        when(atualizarHotelUseCase.executar(1L, requestData)).thenReturn(null);

        ResponseEntity<HotelPublicData> responseEntity = controller.atualizarHotel(1L, requestData);

        assertEquals(404, responseEntity.getStatusCodeValue());
    }
}