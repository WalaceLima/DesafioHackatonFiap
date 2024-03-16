package com.fiap.desafioHackaton.infraestructure.quarto.entitySchema;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class QuartoEntityTest {

    @Mock
    private PredioEntity predioEntity;

    @Mock
    private TipoQuartoEntity tipoQuartoEntity;

    @InjectMocks
    private QuartoEntity quartoEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldConvertToEntitySuccessfully() {
        when(predioEntity.toEntity()).thenReturn(null);
        when(tipoQuartoEntity.toEntity()).thenReturn(null);

        Quarto quarto = quartoEntity.toEntity();

        assertEquals(quartoEntity.getId(), quarto.getId());
        assertEquals(quartoEntity.getValorDiaria(), quarto.getValorDiaria());
        assertEquals(quartoEntity.getStatus(), quarto.getStatus());
    }

    @Test
    public void shouldConvertToEntityToPredioSuccessfully() {
        when(tipoQuartoEntity.toEntityWithMoveis()).thenReturn(null);

        Quarto quarto = quartoEntity.toEntityToPredio();

        assertEquals(quartoEntity.getId(), quarto.getId());
        assertEquals(quartoEntity.getValorDiaria(), quarto.getValorDiaria());
        assertEquals(quartoEntity.getStatus(), quarto.getStatus());
    }

    @Test
    public void shouldConvertToSimpleEntitySuccessfully() {
        when(predioEntity.toEntity()).thenReturn(null);
        when(tipoQuartoEntity.toEntity()).thenReturn(null);

        Quarto quarto = quartoEntity.toSimpleEntity();

        assertEquals(quartoEntity.getId(), quarto.getId());
        assertEquals(quartoEntity.getValorDiaria(), quarto.getValorDiaria());
        assertEquals(quartoEntity.getStatus(), quarto.getStatus());
    }
}