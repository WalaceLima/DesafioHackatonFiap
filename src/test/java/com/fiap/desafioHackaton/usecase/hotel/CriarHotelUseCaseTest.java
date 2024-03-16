package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;
import com.fiap.desafioHackaton.usecase.hotel.dto.IHotelCadastroRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class CriarHotelUseCaseTest {

    @Mock
    private HotelGateway hotelGateway;
    @Mock
    private IHotelCadastroRequestData dados;

    private CriarHotelUseCase criarHotelUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        criarHotelUseCase = new CriarHotelUseCase(hotelGateway);
    }

    @Test
    void deveCriarHotelComSucesso() {
        EnderecoCadastroRequestData enderecoData = new EnderecoCadastroRequestData("Rua Teste", "12345678", "Cidade Teste", "Estado Teste");
        when(dados.nome()).thenReturn("Hotel Teste");
        when(dados.endereco()).thenReturn(enderecoData);

        Hotel hotelEsperado = new Hotel("Hotel Teste", new Endereco("Estado Teste", "Rua Teste", "12345678", "Cidade Teste"));
        when(hotelGateway.criar(any(Hotel.class))).thenReturn(hotelEsperado);

        Hotel hotelCriado = criarHotelUseCase.executar(dados);

        assertNotNull(hotelCriado);
        assertEquals(hotelEsperado.getNome(), hotelCriado.getNome());
        assertEquals(hotelEsperado.getEndereco().getCidade(), hotelCriado.getEndereco().getCidade());
    }

}
