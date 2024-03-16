package com.fiap.desafioHackaton.domain.hotel.gateway;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;

import java.util.List;
import java.util.Optional;

public interface HotelGateway {


    Hotel criar(Hotel hotel);

    Hotel atualizar(Hotel hotel);

    Hotel adicionarPredio(Hotel hotel);

    Hotel adicionarServico(Hotel hotel);

    Hotel adicionarItem(Hotel hotel);

    List<Hotel> listar();

    Optional<Hotel> buscarPorId(Long id);

    Optional<List<Hotel>> buscarPorNome(String nome);

    Optional<List<Hotel>> buscarPorLogradouro(String endereco);

    Optional<List<Hotel>> buscarPorCep(String cep);


    void deletar(Hotel hotel);


    Hotel removerServico(Hotel hotel);

    Hotel removerItem(Hotel hotel);

    void removerRelacionamentoItem(Item item);

    void removerRelacionamentoServico(Servico servico);
}
