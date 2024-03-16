package com.fiap.desafioHackaton.usecase.hospede.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HospedeUtilsTest {

    @Test
    void testPassaporteNaoInformado() {
        assertTrue(ClienteUtils.passaporteNaoInformado(null));
        assertTrue(ClienteUtils.passaporteNaoInformado(""));
        assertFalse(ClienteUtils.passaporteNaoInformado("123456789"));
    }

    @Test
    void testCpfNaoInformado() {
        assertTrue(ClienteUtils.cpfNaoInformado(null));
        assertTrue(ClienteUtils.cpfNaoInformado(""));
        assertFalse(ClienteUtils.cpfNaoInformado("12345678901"));
    }

    @Test
    void testEBrasileiro() {
        assertTrue(ClienteUtils.eBrasileiro("br"));
        assertTrue(ClienteUtils.eBrasileiro("brasil"));
        assertFalse(ClienteUtils.eBrasileiro("usa"));
    }
}