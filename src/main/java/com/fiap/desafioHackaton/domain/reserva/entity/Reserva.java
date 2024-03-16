package com.fiap.desafioHackaton.domain.reserva.entity;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private Long id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private BigDecimal valorReserva;
    private BigDecimal valorTotal;
    private Integer quantidadePessoas;
    private Hospede responsavelReserva;
    private List<Quarto> quartosReservados = new ArrayList<>();
    private List<Item> itensConsumidos = new ArrayList<>();
    private List<Servico> servicosConsumidos = new ArrayList<>();


    public Reserva() {
    }

    public Reserva(Long id, LocalDate dataInicial, LocalDate dataFinal, BigDecimal valorReserva,
                   BigDecimal valorTotal, Integer quantidadePessoas, Hospede responsavelReserva,
                   List<Quarto> quartosReservados, List<Item> itensConsumidos, List<Servico> servicosConsumidos) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorReserva = valorReserva;
        this.valorTotal = valorTotal;
        this.quantidadePessoas = quantidadePessoas;
        this.responsavelReserva = responsavelReserva;
        this.quartosReservados = quartosReservados;
        this.itensConsumidos = itensConsumidos;
        this.servicosConsumidos = servicosConsumidos;
    }

    public Reserva(Long id, LocalDate dataInicial, LocalDate dataFinal, BigDecimal valorReserva, BigDecimal valorTotal, Integer quantidadePessoas, Hospede entity, List<Quarto> list){
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.valorReserva = valorReserva;
        this.valorTotal = valorTotal;
        this.quantidadePessoas = quantidadePessoas;
        this.responsavelReserva = entity;
        this.quartosReservados = list;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public BigDecimal getValorReserva() {
        return valorReserva;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public Hospede getResponsavelReserva() {
        return responsavelReserva;
    }

    public List<Quarto> getQuartosReservados() {
        if(quartosReservados == null) {
            quartosReservados = new ArrayList<>();
        }
        return quartosReservados;
    }

    public List<Item> getItensConsumidos() {
        if(itensConsumidos == null) {
            itensConsumidos = new ArrayList<>();
        }
        return itensConsumidos;
    }

    public List<Servico> getServicosConsumidos() {
        if(servicosConsumidos == null) {
            servicosConsumidos = new ArrayList<>();
        }
        return servicosConsumidos;
    }
}
