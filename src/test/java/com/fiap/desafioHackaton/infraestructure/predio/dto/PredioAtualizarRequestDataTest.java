package com.fiap.desafioHackaton.infraestructure.predio.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredioAtualizarRequestDataTest {

    @Test
    public void shouldReturnCorrectNameWhenGetNameIsCalled() {
        PredioAtualizarRequestData requestData = new PredioAtualizarRequestData("Test Name");

        assertEquals("Test Name", requestData.nome());
    }

    @Test
    public void shouldReturnEmptyStringWhenNameIsEmpty() {
        PredioAtualizarRequestData requestData = new PredioAtualizarRequestData("");

        assertEquals("", requestData.nome());
    }

    @Test
    public void shouldReturnNullWhenNameIsNull() {
        PredioAtualizarRequestData requestData = new PredioAtualizarRequestData(null);

        assertEquals(null, requestData.nome());
    }
}