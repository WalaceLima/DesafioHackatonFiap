package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelItensPublicData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarItemUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdicionarItemControllerTest {

    private AdicionarItemUseCase adicionarItemUseCase;
    private AdicionarItemController controller;

    @BeforeEach
    public void setUp() {
        adicionarItemUseCase = Mockito.mock(AdicionarItemUseCase.class);
        controller = new AdicionarItemController(adicionarItemUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldAddItemToHotelWhenDataIsValid() {
        Hotel hotel = new Hotel();
        when(adicionarItemUseCase.executar(1L, 1L)).thenReturn(hotel);

        ResponseEntity<HotelItensPublicData> responseEntity = controller.adicionarItemaoHotel(1L, 1L);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}