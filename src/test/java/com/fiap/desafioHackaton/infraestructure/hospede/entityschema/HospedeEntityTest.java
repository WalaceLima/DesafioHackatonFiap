package com.fiap.desafioHackaton.infraestructure.hospede.entityschema;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HospedeEntityTest {

    @Test
    public void testEquals() {
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

        ClienteEntity clienteEntity1 = new ClienteEntity(id, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);
        ClienteEntity clienteEntity2 = new ClienteEntity(id, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act & Assert
        assertEquals(clienteEntity1, clienteEntity2);
    }

    @Test
    public void testNotEquals() {
        // Arrange
        Long id1 = 1L;
        Long id2 = 2L;
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        ClienteEntity clienteEntity1 = new ClienteEntity(id1, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);
        ClienteEntity clienteEntity2 = new ClienteEntity(id2, paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act & Assert
        assertNotEquals(clienteEntity1, clienteEntity2);
    }
}
