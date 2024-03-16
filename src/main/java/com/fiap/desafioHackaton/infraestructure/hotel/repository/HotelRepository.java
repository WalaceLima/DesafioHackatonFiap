package com.fiap.desafioHackaton.infraestructure.hotel.repository;

import com.fiap.desafioHackaton.infraestructure.hotel.entityschema.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {

    public Optional<List<HotelEntity>> findByNome(String nome);

    public Optional<List<HotelEntity>> findByEnderecoCep(String cep);

    public Optional<List<HotelEntity>> findByEnderecoLogradouro(String endereco);


}
