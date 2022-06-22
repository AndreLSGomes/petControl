package br.com.pet.crud.model;

import br.com.pet.crud.enums.Enum_StatusCadastro;
import br.com.pet.crud.enums.Enum_PorteAnimal;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet", allocationSize = 1, initialValue = 1)
public class Animal {

    private static final long serialVersionUID = 1L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pet")
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String especieAnimal;
    private Enum_PorteAnimal porteAnimal;
    private Enum_StatusCadastro statusCadastro;

/*
    // Construtor
    public Animal(Long id, String nome, Date dataNascimento, String especieAnimal, Enum_PorteAnimal porteAnimal, Enum_StatusCadastro statusCadastro) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.especieAnimal = especieAnimal;
        this.porteAnimal = porteAnimal;
        this.statusCadastro = statusCadastro;
    }
*/

    // Métodos acessores
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(String especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public Enum_PorteAnimal getPorteAnimal() {
        return porteAnimal;
    }

    public void setPorteAnimal(Enum_PorteAnimal porteAnimal) {
        this.porteAnimal = porteAnimal;
    }

    public Enum_StatusCadastro getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(Enum_StatusCadastro statusCadastro) {
        this.statusCadastro = statusCadastro;
    }
}