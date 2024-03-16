package com.fiap.desafioHackaton.infraestructure.reserva.repository;

import com.fiap.desafioHackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository  extends JpaRepository<ReservaEntity, Long> {
    @Query("SELECT r FROM ReservaEntity r JOIN r.quartoEntities q WHERE q.idHotel = :idHotel")
    List<ReservaEntity> findByHotel_Id(@Param("idHotel") Long idHotel);
    @Query("SELECT r FROM ReservaEntity r WHERE r.dataInicial >= :dataInicial and r.dataFinal <= :dataFinal")
    List<ReservaEntity> findByDataReservaBetween(@Param("dataInicial") LocalDate dataInicial, @Param("dataFinal") LocalDate dataFinal);
    List<ReservaEntity> findByCliente_Cpf(String cpf);
}
