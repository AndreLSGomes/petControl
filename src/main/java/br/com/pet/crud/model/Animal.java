package br.com.pet.crud.model;

import br.com.pet.crud.enums.Enum_Status;
import br.com.pet.crud.enums.Enum_PorteAnimal;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_pet", sequenceName = "seq_pet", allocationSize = 1, initialValue = 1)
public class Animal {

    private static final long serialVersionUID = 1L;

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pet")
    private Long id;
    private String nome;
    private String dataNascimento;
    private String especieAnimal;
    private Enum_PorteAnimal porteAnimal;
    private Enum_Status cadastroAtivo;

/*
    // Construtor
    public Animal(Long id, String nome, String dataNascimento, String especieAnimal, Enum_PorteAnimal porteAnimal, Enum_Status cadastroAtivo) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.especieAnimal = especieAnimal;
        this.porteAnimal = porteAnimal;
        this.cadastroAtivo = cadastroAtivo;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public Enum_Status getCadastroAtivo() {
        return cadastroAtivo;
    }

    public void setCadastroAtivo(Enum_Status cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }
}