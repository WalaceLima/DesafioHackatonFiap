package com.fiap.desafioHackaton.usecase.hospede;

import com.fiap.desafioHackaton.infraestructure.hospede.gateway.EnvioEmailGateway;
import com.fiap.desafioHackaton.usecase.reserva.BuscarReservaPorIdUseCase;
import com.fiap.desafioHackaton.usecase.reserva.FechamentoReservaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ResourceLoader;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FechamentoReservaUseCaseTest {

    @Mock
    private EnvioEmailGateway envioEmailGateway;
    @Mock
    private ResourceLoader resourceLoader;
    @Mock
    private BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;

    private FechamentoReservaUseCase fechamentoReservaUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fechamentoReservaUseCase = new FechamentoReservaUseCase(envioEmailGateway, resourceLoader, buscarReservaPorIdUseCase);
    }

    @Test
    public void shouldSendEmailWhenParametersAreValid() {
        String to = "test@test.com";
        String subject = "Test Subject";
        String message = "Test Message";

        fechamentoReservaUseCase.envioEmail(to, subject, message);

        verify(envioEmailGateway, times(1)).sendEmail(to, subject, message);
    }

    @Test
    public void shouldThrowExceptionWhenEmailSendingFails() {
        String to = "test@test.com";
        String subject = "Test Subject";
        String message = "Test Message";

        doThrow(RuntimeException.class).when(envioEmailGateway).sendEmail(to, subject, message);

        assertThrows(RuntimeException.class, () -> fechamentoReservaUseCase.envioEmail(to, subject, message));
    }
}