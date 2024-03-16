package com.fiap.desafioHackaton.infraestructure.hospede.entityschema;

import com.fiap.desafioHackaton.domain.hospede.entity.Hospede;
import com.fiap.desafioHackaton.infraestructure.reserva.entitySchema.ReservaEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hospede")
public class ClienteEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoPaisOrigem;
    private String telefone;
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<ReservaEntity> reservaEntities;

    public ClienteEntity() {
    }


    public ClienteEntity(Hospede hospede) {
        this.id = hospede.getId();
        this.paisOrigem = hospede.getPaisOrigem();
        this.cpf = hospede.getCpf();
        this.passaporte = hospede.getPassaporte();
        this.nome = hospede.getNome();
        this.dataNascimento = hospede.getDataNascimento();
        this.enderecoPaisOrigem = hospede.getEnderecoPaisOrigem();
        this.telefone = hospede.getTelefone();
        this.email = hospede.getEmail();
    }

    public ClienteEntity(Long id, String paisOrigem, String cpf, String passaporte, String nome, LocalDate dataNascimento,
                         String enderecoPaisOrigem, String telefone, String email) {
        this.id = id;
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }

    public Hospede toCliente() {
        Hospede hospede = new Hospede(this.getId(),
                this.getPaisOrigem(), this.getCpf(), this.getPassaporte(),
                this.getNome(), this.getDataNascimento(), this.getEnderecoPaisOrigem(), this.getTelefone(), this.getEmail()
        );

        return hospede;
    }

    public List<ReservaEntity> getReservaEntities() {
        return reservaEntities;
    }

    public void setReservaEntities(List<ReservaEntity> reservaEntities) {
        this.reservaEntities = reservaEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEnderecoPaisOrigem() {
        return enderecoPaisOrigem;
    }

    public void setEnderecoPaisOrigem(String enderecoPaisOrigem) {
        this.enderecoPaisOrigem = enderecoPaisOrigem;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cpf, that.cpf);
    }

    public Hospede toEntity(){
        return new Hospede(
                this.id,
                this.paisOrigem,
                this.cpf,
                this.passaporte,
                this.nome,
                this.dataNascimento,
                this.enderecoPaisOrigem,
                this.telefone,
                this.email
        );
    }
}
