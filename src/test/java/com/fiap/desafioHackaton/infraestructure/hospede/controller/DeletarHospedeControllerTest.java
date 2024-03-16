package com.fiap.desafioHackaton.infraestructure.hospede.controller;

import com.fiap.desafioHackaton.usecase.hospede.DeletarHospedeUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.doNothing;

public class DeletarHospedeControllerTest {

    private DeletarHospedeUseCase deletarHospedeUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        deletarHospedeUseCase = Mockito.mock(DeletarHospedeUseCase.class);
        DeletarHospedeController controller = new DeletarHospedeController(deletarHospedeUseCase);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testDeletarClienteValidRequest() throws Exception {

        doNothing().when(deletarHospedeUseCase).execute(ArgumentMatchers.anyLong());

    }
}
