package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.usecase.hotel.RemoverServicoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RemoverServicoControllerTest {

    private RemoverServicoUseCase removerServicoUseCase;
    private RemoverServicoController controller;

    @BeforeEach
    public void setUp() {
        removerServicoUseCase = Mockito.mock(RemoverServicoUseCase.class);
        controller = new RemoverServicoController(removerServicoUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnNoContentWhenServiceIsRemovedFromHotel() {
        Hotel hotel = new Hotel();
        when(removerServicoUseCase.executar(1L, 1L)).thenReturn(hotel);

        ResponseEntity<Void> responseEntity = controller.removerServicoHotel(1L, 1L);

        assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenServiceRemovalFails() {
        when(removerServicoUseCase.executar(1L, 1L)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Void> responseEntity = controller.removerServicoHotel(1L, 1L);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}