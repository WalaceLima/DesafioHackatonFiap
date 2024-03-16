package com.fiap.desafioHackaton.domain.hospede.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospedeTest {

    @Test
    public void testCliente() {

        Long id = 1L;
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";


        Hospede hospede = new Hospede(id, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);


        assertEquals(id, hospede.getId());
        assertEquals(paisOrigem, hospede.getPaisOrigem());
        assertEquals(cpf, hospede.getCpf());
        assertEquals(passaporte, hospede.getPassaporte());
        assertEquals(nome, hospede.getNome());
        assertEquals(dataNascimento, hospede.getDataNascimento());
        assertEquals(enderecoPaisOrigem, hospede.getEnderecoPaisOrigem());
        assertEquals(telefone, hospede.getTelefone());
        assertEquals(email, hospede.getEmail());
    }
}
