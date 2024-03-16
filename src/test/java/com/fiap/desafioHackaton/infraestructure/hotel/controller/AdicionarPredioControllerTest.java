package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPrediosPublicData;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioRequestData;
import com.fiap.desafioHackaton.usecase.hotel.AdicionarPredioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdicionarPredioControllerTest {

    private AdicionarPredioUseCase adicionarPredioUseCase;
    private AdicionarPredioController controller;

    @BeforeEach
    public void setUp() {
        adicionarPredioUseCase = Mockito.mock(AdicionarPredioUseCase.class);
        controller = new AdicionarPredioController(adicionarPredioUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldAddBuildingToHotelWhenDataIsValid() {
        Hotel hotel = new Hotel();
        when(adicionarPredioUseCase.executar(1L, new PredioRequestData("teste"))).thenReturn(hotel);

        ResponseEntity<HotelPrediosPublicData> responseEntity = controller.adicionarPredio(1L, new PredioRequestData("teste"));

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}