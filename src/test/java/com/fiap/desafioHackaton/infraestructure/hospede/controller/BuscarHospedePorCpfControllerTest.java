package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.usecase.hospede.BuscarHospedePorCpfUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BuscarHospedePorCpfControllerTest {

    private BuscarHospedePorCpfUseCase buscarHospedePorCpfUseCase;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarHospedePorCpfUseCase = Mockito.mock(BuscarHospedePorCpfUseCase.class);
        BuscarClientePorCpfController controller = new BuscarClientePorCpfController(buscarHospedePorCpfUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarClientePorCpfValidRequest() throws Exception {
        Hospede hospede = new Hospede();
        hospede.setCpf("12345678901");

        when(buscarHospedePorCpfUseCase.execute(anyString())).thenReturn(hospede);

        mockMvc.perform(get("/clientes/cpf/{cpf}", "12345678901"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf", is("12345678901")));
    }

}
