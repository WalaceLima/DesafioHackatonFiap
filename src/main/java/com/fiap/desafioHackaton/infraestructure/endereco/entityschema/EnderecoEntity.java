package com.fiap.desafioHackaton.infraestructure.endereco.entityschema;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class EnderecoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private String cidade;
    private String estado;


    public EnderecoEntity() {
    }

    public EnderecoEntity(Long id, String logradouro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoEntity(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.logradouro = endereco.getLogradouro();
    }

    public Endereco toEntity() {
        return new Endereco(
                this.id,
                this.logradouro,
                this.cep,
                this.cidade,
                this.estado
        );

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
