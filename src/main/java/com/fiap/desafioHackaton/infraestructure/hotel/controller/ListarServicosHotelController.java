package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;
import com.fiap.desafioHackaton.usecase.hotel.ListarServicosHotelUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Hotel", description = "Hotel API")
@Controller
public class ListarServicosHotelController {

    private final ListarServicosHotelUseCase listarServicosHotelUseCase;

    public ListarServicosHotelController(ListarServicosHotelUseCase listarServicosHotelUseCase) {
        this.listarServicosHotelUseCase = listarServicosHotelUseCase;
    }

    @GetMapping("/hotel/{id}/servicos")
    @Operation(summary = "listar todos os serviços disponíveis de um hotel")
    public ResponseEntity<List<ServicoPublicData>> buscarServicos(@PathVariable Long id) {

        List<ServicoPublicData> response = this.listarServicosHotelUseCase.executar(id).stream().map(ServicoPublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
