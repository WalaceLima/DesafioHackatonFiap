package com.fiap.desafioHackaton.infraestructure.hotel.controller;

import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;
import com.fiap.desafioHackaton.usecase.hotel.ListarItensHotelUseCase;
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
public class ListarItensHotelController {

    private final ListarItensHotelUseCase listarItensHotelUseCase;

    public ListarItensHotelController(ListarItensHotelUseCase listarItensHotelUseCase) {
        this.listarItensHotelUseCase = listarItensHotelUseCase;
    }

    @GetMapping("/hotel/{id}/itens")
    @Operation(summary = "listar todos os itens disponíveis de um hotel")
    public ResponseEntity<List<ItemPublicData>> buscarItens(@PathVariable Long id) {

        List<ItemPublicData> response = this.listarItensHotelUseCase.executar(id).stream().map(ItemPublicData::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}
