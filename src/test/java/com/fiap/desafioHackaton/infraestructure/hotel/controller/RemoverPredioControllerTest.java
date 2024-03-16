package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.usecase.hotel.RemoverPredioUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RemoverPredioControllerTest {

    private RemoverPredioUseCase removerPredioUseCase;
    private RemoverPredioController controller;

    @BeforeEach
    public void setUp() {
        removerPredioUseCase = Mockito.mock(RemoverPredioUseCase.class);
        controller = new RemoverPredioController(removerPredioUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnNoContentWhenBuildingIsRemoved() {
        when(removerPredioUseCase.executar(1L, 1L)).thenReturn(null);

        ResponseEntity<Void> responseEntity = controller.removerPredio(1L, 1L);

        assertEquals(204, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenBuildingRemovalFails() {
        when(removerPredioUseCase.executar(1L, 1L)).thenThrow(new IllegalArgumentException());

        ResponseEntity<Void> responseEntity = controller.removerPredio(1L, 1L);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}