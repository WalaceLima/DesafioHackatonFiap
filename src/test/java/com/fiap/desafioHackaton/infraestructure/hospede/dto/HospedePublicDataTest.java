package com.fiap.desafioHackaton.infraestructure.hospede.dto;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospedePublicDataTest {

    @Test
    public void testClientePublicData() {
        // Arrange
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

        // Act
        HospedePublicData clientePublicData = new HospedePublicData(hospede);

        // Assert
        assertEquals(id, clientePublicData.id());
        assertEquals(paisOrigem, clientePublicData.paisOrigem());
        assertEquals(cpf, clientePublicData.cpf());
        assertEquals(passaporte, clientePublicData.passaporte());
        assertEquals(nome, clientePublicData.nome());
        assertEquals(dataNascimento, clientePublicData.dataNascimento());
        assertEquals(enderecoPaisOrigem, clientePublicData.enderecoPaisOrigem());
        assertEquals(telefone, clientePublicData.telefone());
        assertEquals(email, clientePublicData.email());
    }
}
