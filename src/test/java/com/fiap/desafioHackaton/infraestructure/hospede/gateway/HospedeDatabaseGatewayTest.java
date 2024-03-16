package com.fiap.desafioHackaton.infraestructure.hospede.gateway;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.hospede.entityschema.ClienteEntity;
import com.fiap.desafioHackaton.infraestructure.hospede.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HospedeDatabaseGatewayTest {

    @Mock
    private ClienteRepository repository;

    private HospedeDatabaseGateway gateway;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gateway = new HospedeDatabaseGateway(repository);
    }

    @Test
    public void testCriar() {

        Hospede hospede = new Hospede();
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        when(repository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        Hospede result = gateway.criar(hospede);

        assertEquals(hospede.getId(), result.getId());
        assertEquals(hospede.getNome(), result.getNome());
        assertEquals(hospede.getCpf(), result.getCpf());
        verify(repository, times(1)).save(clienteEntity);
    }

    @Test
    public void testAtualizar() {

        Hospede hospede = new Hospede();
        hospede.setId(1L);
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        when(repository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));
        when(repository.save(any(ClienteEntity.class))).thenReturn(clienteEntity);

        Hospede result = gateway.atualizar(hospede);

        assertEquals(hospede.getId(), result.getId());
        assertEquals(hospede.getNome(), result.getNome());
        assertEquals(hospede.getCpf(), result.getCpf());
        verify(repository, times(1)).findById(hospede.getId());
        verify(repository, times(1)).save(clienteEntity);
    }

    @Test
    public void testListar() {
        // Arrange
        ClienteEntity clienteEntity = new ClienteEntity(new Hospede());
        List<ClienteEntity> clienteEntities = Arrays.asList(clienteEntity);
        when(repository.findAll()).thenReturn(clienteEntities);

        // Act
        List<Hospede> result = gateway.listar();

        // Assert
        assertEquals(clienteEntities.size(), result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testBuscarPorId() {
        // Arrange
        Hospede hospede = new Hospede();
        hospede.setId(1L);
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        when(repository.findById(anyLong())).thenReturn(Optional.of(clienteEntity));

        // Act
        Optional<Hospede> result = gateway.buscarPorId(hospede.getId());

        // Assert
        assertEquals(hospede.getId(), result.get().getId());
        verify(repository, times(1)).findById(hospede.getId());
    }

    @Test
    public void testBuscarPorCpf() {
        // Arrange
        Hospede hospede = new Hospede();
        hospede.setCpf("12345678901");
        ClienteEntity clienteEntity = new ClienteEntity(hospede);
        when(repository.findByCpf(anyString())).thenReturn(Optional.of(clienteEntity));

        // Act
        Optional<Hospede> result = gateway.buscarPorCpf(hospede.getCpf());

        // Assert
        assertEquals(hospede.getCpf(), result.get().getCpf());
        verify(repository, times(1)).findByCpf(hospede.getCpf());
    }

    @Test
    public void testDeletar() {
        // Arrange
        Hospede hospede = new Hospede();
        ClienteEntity clienteEntity = new ClienteEntity(hospede);

        // Act
        gateway.deletar(hospede);

        // Assert
        verify(repository, times(1)).delete(clienteEntity);
    }
}
