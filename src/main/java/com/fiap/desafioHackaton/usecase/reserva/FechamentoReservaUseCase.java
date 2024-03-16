package com.fiap.desafioHackaton.usecase.reserva;

import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.infraestructure.hospede.dto.FecharReservaDto;
import com.fiap.desafioHackaton.infraestructure.hospede.gateway.EnvioEmailGateway;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Collectors;

public class FechamentoReservaUseCase {

    private final EnvioEmailGateway envioEmailGateway;
    private final ResourceLoader resourceLoader;
    private final BuscarReservaPorIdUseCase buscarReservaPorIdUseCase;

    private static final String NAME_PLACEHOLDER = "{{nome}}";
    private static final String START_DATE_PLACEHOLDER = "{{dataInicio}}";
    private static final String END_DATE_PLACEHOLDER = "{{dataFim}}";
    private static final String LIST_ROOM_TYPE_PLACEHOLDER = "{{tipoQuarto}}";
    private static final String TOTAL_VALUE_PLACEHOLDER = "{{valorTotal}}";
    private static final String LIST_SERVICE_PLACEHOLDER = "{{listaDeServicos}}";
    private static final String QTD_QUARTOS = "{{qtdQuartos}}";
    private static final String NAME_HOTEL = "{{nomeHotel}}";

    public FechamentoReservaUseCase(EnvioEmailGateway envioEmailGateway, ResourceLoader resourceLoader, BuscarReservaPorIdUseCase buscarReservaPorIdUseCase) {
        this.envioEmailGateway = envioEmailGateway;
        this.resourceLoader = resourceLoader;
        this.buscarReservaPorIdUseCase = buscarReservaPorIdUseCase;
    }

    public String fecharReserva(Long idReserva) throws Exception {
        var resource = resourceLoader.getResource("classpath:/template/confirmacao_reserva.html");
        try (var reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            FecharReservaDto details = prepareReservaDetails(idReserva);
            String content = reader.lines().collect(Collectors.joining("\n"));
            String emailContent = replacePlaceholders(content, details);
            envioEmailGateway.sendEmail(details.getEmail(), "Confirmação de Reserva", emailContent);
            return "Email enviado com sucesso!";
        }
    }

    private FecharReservaDto prepareReservaDetails(Long idReserva) {
        Reserva reserva = buscarReservaPorIdUseCase.executar(idReserva);
        FecharReservaDto details = new FecharReservaDto();
        details.setDataCheckIn(reserva.getDataInicial());
        details.setDataCheckOut(reserva.getDataFinal());
        details.setNomeCliente(reserva.getResponsavelReserva().getNome());
        details.setEmail(reserva.getResponsavelReserva().getEmail());
        details.setQuartosReservados(reserva.getQuartosReservados());
        details.setValorTotal(reserva.getValorTotal());
        Optional<String> nameHotel = reserva.getQuartosReservados().stream()
                .map(quarto -> quarto.getPredio().getHotel().getNome())
                .distinct()
                .findFirst();
        details.setNomeHotel(nameHotel.isPresent()? nameHotel.get() : "Hotel");
        details.setServicosConsumidos(reserva.getServicosConsumidos());
        return details;
    }

    private String replacePlaceholders(String content, FecharReservaDto details) {
        String listaTipoQuartos = details.getQuartosReservados().stream()
                .map(quarto -> "<li>" + quarto.getTipoQuarto().getNomeTipo() + "</li>")
                .collect(Collectors.joining("\n"));
        String servicos = details.getServicosConsumidos() != null && !details.getServicosConsumidos().isEmpty() ? details.getServicosConsumidos().stream()
                .map(servico -> servico != null ? "<li>" + servico.getNome() + "</li>" : "")
                .collect(Collectors.joining("\n")) : "";

        content = content
                .replace(NAME_PLACEHOLDER, details.getNomeCliente())
                .replace(START_DATE_PLACEHOLDER, details.getDataCheckIn().toString())
                .replace(END_DATE_PLACEHOLDER, details.getDataCheckOut().toString())
                .replace(LIST_ROOM_TYPE_PLACEHOLDER, listaTipoQuartos)
                .replace(TOTAL_VALUE_PLACEHOLDER, details.getValorTotal().toString())
                .replace(NAME_HOTEL, details.getNomeHotel())
                .replace(QTD_QUARTOS, String.valueOf(details.getQuartosReservados().size()));

        if (!servicos.isEmpty()) {
            content = content.replace(LIST_SERVICE_PLACEHOLDER, servicos);
        } else {
            content = content.replace(LIST_SERVICE_PLACEHOLDER, "Nenhum serviço consumido.");
        }

        return content;
    }


    public void envioEmail(String to, String subject, String message) {
        envioEmailGateway.sendEmail(to, subject, message);
    }
}