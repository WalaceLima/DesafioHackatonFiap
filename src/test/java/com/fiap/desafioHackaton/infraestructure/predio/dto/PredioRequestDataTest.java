package com.fiap.desafioHackaton.infraestructure.predio.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PredioRequestDataTest {

    @Test
    public void shouldReturnCorrectNameWhenGetNameIsCalled() {
        PredioRequestData requestData = new PredioRequestData("Test Name");

        assertEquals("Test Name", requestData.nome());
    }

    @Test
    public void shouldReturnEmptyStringWhenNameIsEmpty() {
        PredioRequestData requestData = new PredioRequestData("");

        assertEquals("", requestData.nome());
    }

    @Test
    public void shouldReturnNullWhenNameIsNull() {
        PredioRequestData requestData = new PredioRequestData(null);

        assertEquals(null, requestData.nome());
    }
}