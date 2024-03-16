package com.fiap.desafioHackaton.infraestructure.config;

import com.fiap.desafioHackaton.infraestructure.hospede.gateway.EnvioEmailGateway;
import com.fiap.desafioHackaton.usecase.reserva.BuscarReservaPorIdUseCase;
import com.fiap.desafioHackaton.usecase.reserva.FechamentoReservaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailMvcConfig {


    @Autowired
    private JavaMailSender javaMailSender;

    @Bean
    public EnvioEmailGateway envioEmailGateway() {
        return new EnvioEmailGateway(javaMailSender);
    }

    @Bean
    public FechamentoReservaUseCase envioEmailUseCase(EnvioEmailGateway envioEmailGateway, ResourceLoader resourceLoader, BuscarReservaPorIdUseCase buscarReservaPorIdUseCase) {
        return new FechamentoReservaUseCase(envioEmailGateway, resourceLoader, buscarReservaPorIdUseCase);
    }
}
