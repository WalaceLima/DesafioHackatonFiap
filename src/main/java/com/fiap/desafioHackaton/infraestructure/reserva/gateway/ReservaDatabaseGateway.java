package com.fiap.desafioHackaton.infraestructure.reserva.gateway;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.domain.reserva.entity.Reserva;
import com.fiap.desafioHackaton.domain.reserva.gateway.ReservaGateway;
import com.fiap.desafioHackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.desafioHackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import com.fiap.desafioHackaton.infraestructure.reserva.repository.ReservaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservaDatabaseGateway implements ReservaGateway {

    private final ReservaRepository repository;

    public ReservaDatabaseGateway(ReservaRepository repository){
        this.repository = repository;
    }

    @Override
    public Reserva criar(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity(reserva);
        return repository.save(reservaEntity).toEntity();
    }

    @Override
    public void deletar(Reserva reserva){
        ReservaEntity reservaEntity = new ReservaEntity(reserva);
        repository.delete(reservaEntity);
    }

    @Override
    public List<Reserva> listarPorCliente(String cpf){
        return repository.findByCliente_Cpf(cpf).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarPorHotel(Long idHotel){
        return repository.findByHotel_Id(idHotel).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Reserva> listarPorPeriodo(LocalDate inicio, LocalDate fim){
        return repository.findByDataReservaBetween(inicio, fim).stream()
                .map(ReservaEntity::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id){
        try {
            return repository.findById(id).map(ReservaEntity::toEntity);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("ID inválido");
        }
    }


    @Override
    public void removerQuartoDeReservas(QuartoEntity quarto){
        List<ReservaEntity> reservaEntities = repository.findAll();
        reservaEntities.forEach(reservaEntity -> {
            reservaEntity.getQuartoEntity().removeIf(quartoEntity -> quartoEntity.getId().equals(quarto.getId()));
            repository.save(reservaEntity);
        });
    }


    @Override
    public void removerClienteDeReserva(Hospede hospede){
        repository.findAll().stream()
                .filter(reservaEntity -> reservaEntity.getCliente().getId().equals(hospede.getId()))
                .forEach(repository::delete);
    }
}
