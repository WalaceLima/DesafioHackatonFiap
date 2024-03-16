package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.usecase.predio.CriarPredioUseCase;
import com.fiap.desafioHackaton.usecase.predio.dto.IPredioRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AdicionarPredioUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;

    @Mock
    private CriarPredioUseCase criarPredioUseCase;

    private AdicionarPredioUseCase adicionarPredioUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adicionarPredioUseCase = new AdicionarPredioUseCase(hotelGateway, criarPredioUseCase);
    }

    @Test
    @DisplayName("Should add building to hotel when hotel and building data are valid")
    void shouldAddBuildingToHotelWhenHotelAndBuildingDataAreValid() {
        Long hotelId = 1L;
        IPredioRequestData dados = mock(IPredioRequestData.class);
        when(dados.nome()).thenReturn("Predio 1");

        Hotel hotel = new Hotel();
        Predio predio = new Predio();

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.of(hotel));
        when(criarPredioUseCase.executar(any(Predio.class))).thenReturn(predio);
        when(hotelGateway.adicionarPredio(hotel)).thenReturn(hotel);

        Hotel hotelComPredio = adicionarPredioUseCase.executar(hotelId, dados);

        assertEquals(hotel, hotelComPredio);
    }

    @Test
    @DisplayName("Should throw exception when hotel is not found")
    void shouldThrowExceptionWhenHotelIsNotFound() {
        Long hotelId = 1L;
        IPredioRequestData dados = mock(IPredioRequestData.class);

        when(hotelGateway.buscarPorId(hotelId)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> adicionarPredioUseCase.executar(hotelId, dados));
    }
}