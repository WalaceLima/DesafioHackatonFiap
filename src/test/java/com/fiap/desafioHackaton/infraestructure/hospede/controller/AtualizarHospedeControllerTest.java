package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedeRequestData;
import com.fiap.desafioHackaton.usecase.hospede.AtualizarHospedeeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AtualizarHospedeControllerTest {

    private AtualizarHospedeeUseCase atualizarHospedeeUseCase;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        atualizarHospedeeUseCase = Mockito.mock(AtualizarHospedeeUseCase.class);
        AtualizarHospedeController controller = new AtualizarHospedeController(atualizarHospedeeUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testAtualizarClienteValidRequest() throws Exception {
        // Arrange
        Hospede hospede = new Hospede();
        when(atualizarHospedeeUseCase.execute(anyLong(), any(HospedeRequestData.class))).thenReturn(hospede);

        // Act & Assert
        mockMvc.perform(put("/clientes/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cpf\":\"12345678901\",\"nome\":\"Fulano\",\"dataNascimento\":\"1990-01-01\",\"paisOrigem\":\"Brasil\",\"telefone\":\"52982222222\",\"enderecoPaisOrigem\":\"Brasil\"}"))
                .andExpect(status().isOk()); // Espera-se um status 200 OK
    }

    @Test
    public void testAtualizarClienteInvalidRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(put("/clientes/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cpf\":null}")) // CPF inválido
                .andExpect(status().isBadRequest()); // Espera-se um erro de Bad Request
    }
}
