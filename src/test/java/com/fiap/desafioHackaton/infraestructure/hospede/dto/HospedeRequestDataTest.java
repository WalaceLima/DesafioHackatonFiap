package com.fiap.desafioHackaton.infraestructure.hospede.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospedeRequestDataTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testClienteRequestData() {
        // Arrange
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(0, violations.size());
    }

    @Test
    public void testClienteRequestDataInvalidEmail() {
        // Arrange
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "invalid email";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Email inválido", violations.iterator().next().getMessage());
    }


    @Test
    public void testClienteRequestDataInvalidPaisOrigem() {
        // Arrange
        String paisOrigem = ""; // Pais de origem vazio
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Pais de origem é obrigatório", violations.iterator().next().getMessage());
    }

    @Test
    public void testClienteRequestDataInvalidCpf() {
        // Arrange
        String cpf = "1234567890123"; // CPF com mais de 11 dígitos
        String paisOrigem = "Brasil";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("CPF deve conter apenas números e ter no máximo 11 dígitos", violations.iterator().next().getMessage());
    }

    @Test
    public void testClienteRequestDataInvalidNome() {
        // Arrange
        String nome = ""; // Nome vazio
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Nome é obrigatório", violations.iterator().next().getMessage());
    }

    @Test
    public void testClienteRequestDataInvalidDataNascimento() {
        // Arrange
        LocalDate dataNascimento = LocalDate.now().plusDays(1); // Data de nascimento no futuro
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        String enderecoPaisOrigem = "Rua A, 123";
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Data de nascimento deve ser uma data no passado no formato yyyy-MM-dd", violations.iterator().next().getMessage());
    }

    @Test
    public void testClienteRequestDataInvalidEnderecoPaisOrigem() {
        // Arrange
        String enderecoPaisOrigem = ""; // Endereço do país de origem vazio
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String telefone = "11987654321";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Endereço do país de origem é obrigatório", violations.iterator().next().getMessage());
    }

    @Test
    public void testClienteRequestDataInvalidTelefone() {
        // Arrange
        String telefone = ""; // Telefone vazio
        String paisOrigem = "Brasil";
        String cpf = "12345678901";
        String passaporte = "AB123456";
        String nome = "João Silva";
        LocalDate dataNascimento = LocalDate.of(1990, 1, 1);
        String enderecoPaisOrigem = "Rua A, 123";
        String email = "joao.silva@example.com";

        HospedeRequestData clienteRequestData = new HospedeRequestData(paisOrigem, cpf, passaporte, nome, dataNascimento, enderecoPaisOrigem, telefone, email);

        // Act
        Set<ConstraintViolation<HospedeRequestData>> violations = validator.validate(clienteRequestData);

        // Assert
        assertEquals(1, violations.size());
        assertEquals("Telefone é obrigatório", violations.iterator().next().getMessage());
    }
}
