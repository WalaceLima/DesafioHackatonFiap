package com.fiap.desafioHackaton.infraestructure.hotel.gateway;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.entityschema.HotelEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class HotelDatabaseGatewayTest {

    @Mock
    private HotelRepository hotelRepository;

    private HotelDatabaseGateway hotelDatabaseGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        hotelDatabaseGateway = new HotelDatabaseGateway(hotelRepository);
    }

    @Test
    void testCriar() {
        Hotel hotel = mock(Hotel.class);
        Endereco endereco = mock(Endereco.class);
        when(hotel.getEndereco()).thenReturn(endereco);
        HotelEntity hotelEntity = new HotelEntity(hotel); 
        when(hotelRepository.save(any(HotelEntity.class))).thenReturn(hotelEntity);

        Hotel result = hotelDatabaseGateway.criar(hotel);

        assertNotNull(result);
        
        verify(hotelRepository).save(any(HotelEntity.class)); 
    }
    @Test
    void testBuscarPorId() {
        Long id = 1L;
        HotelEntity hotelEntity = mock(HotelEntity.class); 
        when(hotelEntity.toCompleteEntity()).thenReturn(new Hotel());
        when(hotelRepository.findById(id)).thenReturn(Optional.of(hotelEntity));

        Optional<Hotel> result = hotelDatabaseGateway.buscarPorId(id);

        assertTrue(result.isPresent());
        verify(hotelRepository).findById(id);
    }
    @Test
    void testBuscarPorNome() {
        String nome = "nome";
        HotelEntity hotelEntity = mock(HotelEntity.class);
        when(hotelEntity.toCompleteEntity()).thenReturn(new Hotel());
        when(hotelRepository.findByNome(nome)).thenReturn(Optional.of(Arrays.asList(hotelEntity)));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorNome(nome);

        assertTrue(result.isPresent());
        verify(hotelRepository).findByNome(nome);
    }
    @Test
    void testBuscarPorLogradouro() {
        String endereco = "endereco";
        HotelEntity hotelEntity = mock(HotelEntity.class);
        when(hotelEntity.toCompleteEntity()).thenReturn(new Hotel());
        when(hotelRepository.findByEnderecoLogradouro(endereco)).thenReturn(Optional.of(Arrays.asList(hotelEntity)));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorLogradouro(endereco);

        assertTrue(result.isPresent());
        verify(hotelRepository).findByEnderecoLogradouro(endereco);
    }
    @Test
    void testBuscarPorCep() {
        String cep = "cep";
        HotelEntity hotelEntity = mock(HotelEntity.class); 
        when(hotelEntity.toCompleteEntity()).thenReturn(new Hotel()); 
        when(hotelRepository.findByEnderecoCep(cep)).thenReturn(Optional.of(Arrays.asList(hotelEntity)));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorCep(cep);

        assertTrue(result.isPresent());
        verify(hotelRepository).findByEnderecoCep(cep);
    }
    @Test
    void testListar() {
        HotelEntity hotelEntity = mock(HotelEntity.class); 
        when(hotelEntity.toEntity()).thenReturn(new Hotel());
        when(hotelRepository.findAll()).thenReturn(Arrays.asList(hotelEntity));

        List<Hotel> result = hotelDatabaseGateway.listar();

        assertNotNull(result);
        verify(hotelRepository).findAll();
    }
    @Test
    void testAtualizar() {
        Hotel hotel = mock(Hotel.class);
        Endereco endereco = mock(Endereco.class);
        when(hotel.getEndereco()).thenReturn(endereco);
        HotelEntity hotelEntity = new HotelEntity(hotel); 
        when(hotelRepository.save(any(HotelEntity.class))).thenReturn(hotelEntity);

        Hotel result = hotelDatabaseGateway.atualizar(hotel);

        assertNotNull(result);
        
        verify(hotelRepository).save(any(HotelEntity.class)); 
    }
        
    @Test
    void testBuscarPorIdWhenRepositoryThrowsException() {
        Long id = 1L;
        when(hotelRepository.findById(id)).thenThrow(new RuntimeException("Error"));

        Optional<Hotel> result = hotelDatabaseGateway.buscarPorId(id);

        assertTrue(result.isEmpty());
    }
    @Test
    void testBuscarPorNomeWhenRepositoryThrowsException() {
        String nome = "nome";
        when(hotelRepository.findByNome(nome)).thenThrow(new RuntimeException("Error"));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorNome(nome);

        assertTrue(result.isEmpty());
    }
    @Test
    void testBuscarPorLogradouroWhenRepositoryThrowsException() {
        String endereco = "endereco";
        when(hotelRepository.findByEnderecoLogradouro(endereco)).thenThrow(new RuntimeException("Error"));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorLogradouro(endereco);

        assertTrue(result.isEmpty());
    }
    @Test
    void testBuscarPorCepWhenRepositoryThrowsException() {
        String cep = "cep";
        when(hotelRepository.findByEnderecoCep(cep)).thenThrow(new RuntimeException("Error"));

        Optional<List<Hotel>> result = hotelDatabaseGateway.buscarPorCep(cep);

        assertTrue(result.isEmpty());
    }
    @Test
    void testListarWhenRepositoryThrowsException() {
        when(hotelRepository.findAll()).thenThrow(new RuntimeException("Error"));

        List<Hotel> result = hotelDatabaseGateway.listar();

        assertNull(result);
    }
    @Test
    void testDeletarWhenRepositoryThrowsException() {
        Hotel hotel = mock(Hotel.class);
        Endereco endereco = mock(Endereco.class);
        when(hotel.getEndereco()).thenReturn(endereco);
        HotelEntity hotelEntity = new HotelEntity(hotel); 
        doThrow(new RuntimeException("Error")).when(hotelRepository).delete(hotelEntity);

        hotelDatabaseGateway.deletar(hotel);
    }
    @Test
    void testAtualizarWhenRepositoryThrowsException() {
        Hotel hotel = mock(Hotel.class); 
        when(hotelRepository.save(any(HotelEntity.class))).thenThrow(new RuntimeException("Error"));

        Hotel result = hotelDatabaseGateway.atualizar(hotel);

        assertNull(result);
    }
    @Test
    void testCriarWhenRepositoryThrowsException() {
        Hotel hotel = mock(Hotel.class);
        when(hotelRepository.save(any(HotelEntity.class))).thenThrow(new RuntimeException("Error"));

        assertThrows(RuntimeException.class, () -> hotelDatabaseGateway.criar(hotel));
    }
    
}