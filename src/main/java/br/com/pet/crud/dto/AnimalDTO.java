package br.com.pet.crud.dto;

import br.com.pet.crud.enums.Enum_PorteAnimal;
import br.com.pet.crud.enums.Enum_StatusCadastro;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AnimalDTO {

    // Atributos
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String especieAnimal;
    private Enum_PorteAnimal porteAnimal;
    private Enum_StatusCadastro statusCadastro;
    private int ano;
    private int mes;
    private int dia;

    // Construtor Vazio
    public AnimalDTO(){}

    // Consturtor para exibir na view
    public AnimalDTO(Long id, String nome, Date dataNascimento, String especieAnimal, Enum_PorteAnimal porteAnimal, Enum_StatusCadastro statusCadastro, int ano, int mes, int dia) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.especieAnimal = especieAnimal;
        this.porteAnimal = porteAnimal;
        this.statusCadastro = statusCadastro;
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    // Métodos acessore
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
}
