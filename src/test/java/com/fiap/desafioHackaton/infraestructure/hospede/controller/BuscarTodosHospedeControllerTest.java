package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.usecase.hospede.BuscarTodosHospedeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BuscarTodosHospedeControllerTest {

    private BuscarTodosHospedeUseCase buscarTodosHospedeUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarTodosHospedeUseCase = Mockito.mock(BuscarTodosHospedeUseCase.class);
        BuscarTodosHospedeController controller = new BuscarTodosHospedeController(buscarTodosHospedeUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarTodosClientesValidRequest() throws Exception {
        Hospede hospede = new Hospede();
        List<Hospede> hospedes = new ArrayList<>();
        hospedes.add(hospede);
        when(buscarTodosHospedeUseCase.execute()).thenReturn(hospedes);

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk());
    }
}
