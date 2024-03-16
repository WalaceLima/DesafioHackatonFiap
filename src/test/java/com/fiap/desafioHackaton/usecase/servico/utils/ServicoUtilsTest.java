package com.fiap.desafioHackaton.usecase.servico.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicoUtilsTest {

    @Test
    public void shouldReturnTrueWhenNameIsNotInformed() {
        assertTrue(ServicoUtils.nomeNaoInformado(null));
        assertTrue(ServicoUtils.nomeNaoInformado(""));
        assertTrue(ServicoUtils.nomeNaoInformado(" "));
    }

    @Test
    public void shouldReturnFalseWhenNameIsInformed() {
        assertFalse(ServicoUtils.nomeNaoInformado("Service Name"));
    }

    @Test
    public void shouldReturnTrueWhenValueIsNotInformed() {
        assertTrue(ServicoUtils.valorNaoInformado(null));
        assertTrue(ServicoUtils.valorNaoInformado(Double.NaN));
    }

    @Test
    public void shouldReturnFalseWhenValueIsInformed() {
        assertFalse(ServicoUtils.valorNaoInformado(100.0));
    }
}