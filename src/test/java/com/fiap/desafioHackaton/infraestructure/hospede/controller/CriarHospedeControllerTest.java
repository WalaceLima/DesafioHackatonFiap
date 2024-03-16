package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.HospedeRequestData;
import com.fiap.desafioHackaton.usecase.hospede.CriarHospedeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CriarHospedeControllerTest {

    private CriarHospedeUseCase criarHospedeUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        criarHospedeUseCase = Mockito.mock(CriarHospedeUseCase.class);
        CriarHospedeController controller = new CriarHospedeController(criarHospedeUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testCriarClienteValidRequest() throws Exception {

        Hospede hospede = new Hospede();
        when(criarHospedeUseCase.executar(ArgumentMatchers.any(HospedeRequestData.class))).thenReturn(hospede);
        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"cpf\":\"12345678901\",\"nome\":\"Fulano\",\"dataNascimento\":\"1990-01-01\",\"paisOrigem\":\"Brasil\",\"telefone\":\"52982222222\",\"enderecoPaisOrigem\":\"Brasil\"}"))
                .andExpect(status().isOk());


    }
}
