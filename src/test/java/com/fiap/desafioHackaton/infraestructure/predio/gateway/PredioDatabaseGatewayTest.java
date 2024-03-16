package com.fiap.desafioHackaton.infraestructure.predio.gateway;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;
import com.fiap.desafioHackaton.infraestructure.predio.repository.PredioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PredioDatabaseGatewayTest {

    @Mock
    private PredioRepository predioRepository;

    private PredioDatabaseGateway predioDatabaseGateway;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        predioDatabaseGateway = new PredioDatabaseGateway(predioRepository);
    }

    @Test
    public void shouldCreatePredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        Endereco endereco = mock(Endereco.class);

        when(hotel.getEndereco()).thenReturn(endereco);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Arrays.asList());

        PredioEntity predioEntity = new PredioEntity(predio);
        when(predioRepository.save(any(PredioEntity.class))).thenReturn(predioEntity);

        Predio result = predioDatabaseGateway.criar(predio);

        assertEquals(predio.getId(), result.getId());
        assertEquals(predio.getNome(), result.getNome());
        assertEquals(predio.getHotel().getId(), result.getHotel().getId());
        assertEquals(predio.getHotel().getNome(), result.getHotel().getNome());
    }

    @Test
    public void shouldUpdatePredio() {
        Predio predio = mock(Predio.class);
        Hotel hotel = mock(Hotel.class);
        Endereco endereco = mock(Endereco.class);

        when(hotel.getEndereco()).thenReturn(endereco);
        when(predio.getHotel()).thenReturn(hotel);
        when(predio.getId()).thenReturn(1L);
        when(predio.getNome()).thenReturn("Test Name");
        when(predio.getQuartos()).thenReturn(Arrays.asList());

        PredioEntity predioEntity = new PredioEntity(predio);
        when(predioRepository.save(any(PredioEntity.class))).thenReturn(predioEntity);

        Predio result = predioDatabaseGateway.atualizar(predio);

        assertEquals(predio.getId(), result.getId());
        assertEquals(predio.getNome(), result.getNome());
        assertEquals(predio.getHotel().getId(), result.getHotel().getId());
        assertEquals(predio.getHotel().getNome(), result.getHotel().getNome());
    }
}