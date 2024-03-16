package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.usecase.hospede.BuscarClienteUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class BuscarHospedeControllerTest {

    private BuscarClienteUseCase buscarClienteUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        buscarClienteUseCase = Mockito.mock(BuscarClienteUseCase.class);
        BuscarHospedeController controller = new BuscarHospedeController(buscarClienteUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testBuscarClienteValidRequest() throws Exception {
        Hospede hospede = new Hospede();
        when(buscarClienteUseCase.execute(anyLong())).thenReturn(hospede);

        mockMvc.perform(get("/clientes/{id}", 1L))
                .andExpect(status().isOk());

    }
}
