package com.fiap.desafioHackaton.infraestructure.amenidade.entityschema;

import com.fiap.desafioHackaton.domain.amenidade.entity.Amenidade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AmenidadeEntityTest {

    private AmenidadeEntity amenidadeEntity;

    @BeforeEach
    public void setUp() {
        amenidadeEntity = new AmenidadeEntity();
    }

    @Test
    public void shouldConvertToEntityWhenDataIsValid() {
        amenidadeEntity.setId(1L);
        amenidadeEntity.setNome("Test Name");

        Amenidade amenidade = amenidadeEntity.toEntity();

        assertEquals(1L, amenidade.getId());
        assertEquals("Test Name", amenidade.getNome());
    }

    @Test
    public void shouldConvertToEntityWhenDataIsNotSet() {
        Amenidade amenidade = amenidadeEntity.toEntity();

        assertNull(amenidade.getId());
        assertNull(amenidade.getNome());
    }

    @Test
    public void shouldSetDataFromEntityWhenEntityIsValid() {
        Amenidade amenidade = new Amenidade(1L, "Test Name");

        amenidadeEntity = new AmenidadeEntity(amenidade);

        assertEquals(1L, amenidadeEntity.getId());
        assertEquals("Test Name", amenidadeEntity.getNome());
    }
}