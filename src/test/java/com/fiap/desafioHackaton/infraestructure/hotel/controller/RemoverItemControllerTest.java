package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.RemoverItemUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RemoverItemControllerTest {

    private RemoverItemUseCase removerItemUseCase;
    private RemoverItemController controller;

    @BeforeEach
    public void setUp() {
        removerItemUseCase = Mockito.mock(RemoverItemUseCase.class);
        controller = new RemoverItemController(removerItemUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnNoContentWhenItemIsRemoved() {
        when(removerItemUseCase.executar(1L, 1L)).thenReturn(null);

        ResponseEntity<Void> responseEntity = controller.removerItemdeHotel(1L, 1L);

        assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenItemRemovalFails() {
        when(removerItemUseCase.executar(1L, 1L)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Void> responseEntity = controller.removerItemdeHotel(1L, 1L);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}