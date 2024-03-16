package com.fiap.desafioHackaton.infraestructure.quarto.repository;

import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartosDisponiveisDTO;
import com.fiap.desafioHackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface QuartoRepository extends JpaRepository<QuartoEntity, Long> {
    List<QuartoEntity> findByTipoQuarto(TipoQuartoEntity tipoQuarto);

    @Query(value = "SELECT new com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartosDisponiveisDTO(" +
            "q.id, q.predio.id, q.idHotel, q.valorDiaria, q.status, q.tipoQuarto)" +
            " FROM QuartoEntity q LEFT JOIN q.reservasEntities r" +
            " WHERE q.status = :status AND (" +
            "   (r.dataInicial IS NULL AND r.dataFinal IS NULL) OR" +
            "   NOT (r.dataInicial BETWEEN :dataInicio AND :dataFim OR r.dataFinal BETWEEN :dataInicio AND :dataFim)" +
            ")")
    Optional<List<QuartosDisponiveisDTO>> listarQuartoPorPeriodoDisponibilidade(LocalDate dataInicio, LocalDate dataFim, Status status);
}
