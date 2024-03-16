package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.DeletarHotelUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DeletarHotelControllerTest {

    private DeletarHotelUseCase deletarHotelUseCase;
    private DeletarHotelController controller;

    @BeforeEach
    public void setUp() {
        deletarHotelUseCase = Mockito.mock(DeletarHotelUseCase.class);
        controller = new DeletarHotelController(deletarHotelUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnNoContentWhenHotelIsDeleted() {
        doNothing().when(deletarHotelUseCase).executar(1L);

        ResponseEntity<Void> responseEntity = controller.deletarHotel(1L);

        assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenHotelDeletionFails() {
        doThrow(new IllegalArgumentException()).when(deletarHotelUseCase).executar(1L);

        ResponseEntity<Void> responseEntity = controller.deletarHotel(1L);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}