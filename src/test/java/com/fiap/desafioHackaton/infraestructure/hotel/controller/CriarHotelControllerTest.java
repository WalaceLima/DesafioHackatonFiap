package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelCadastroRequestData;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.usecase.hotel.CriarHotelUseCase;
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

public class CriarHotelControllerTest {

    private CriarHotelUseCase criarHotelUseCase;
    private CriarHotelController controller;

    @BeforeEach
    public void setUp() {
        criarHotelUseCase = Mockito.mock(CriarHotelUseCase.class);
        controller = new CriarHotelController(criarHotelUseCase);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldReturnHotelWhenDataIsValid() {
        HotelCadastroRequestData dados = mock(HotelCadastroRequestData.class);
        EnderecoCadastroRequestData endereco = mock(EnderecoCadastroRequestData.class);
        when(dados.endereco()).thenReturn(endereco);
        Hotel hotel = new Hotel();
        when(criarHotelUseCase.executar(dados)).thenReturn(hotel);

        ResponseEntity<HotelPublicData> responseEntity = controller.criarHotel(dados);

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void shouldReturnBadRequestWhenDataIsInvalid() {
        HotelCadastroRequestData dados = mock(HotelCadastroRequestData.class);
        when(criarHotelUseCase.executar(dados)).thenThrow(new IllegalArgumentException());

        ResponseEntity<HotelPublicData> responseEntity = controller.criarHotel(dados);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}