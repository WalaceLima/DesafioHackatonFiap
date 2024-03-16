package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelServicosPublicData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarServicoUseCase;
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

public class AdicionarServicoControllerTest {

    private AdicionarServicoUseCase adicionarServicoUseCase;
    private AdicionarServicoController controller;

    @BeforeEach
    public void setUp() {
        adicionarServicoUseCase = Mockito.mock(AdicionarServicoUseCase.class);
        controller = new AdicionarServicoController(adicionarServicoUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldAddServiceToHotelWhenDataIsValid() {
        Hotel hotelMock = mock(Hotel.class);

        when(adicionarServicoUseCase.executar(1L, 1L)).thenReturn(hotelMock);

        ResponseEntity<HotelServicosPublicData> responseEntity = controller.adicionarServicoaHotel(1L, 1L);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}