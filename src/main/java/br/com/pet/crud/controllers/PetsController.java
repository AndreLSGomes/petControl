package br.com.pet.crud.controllers;

import br.com.pet.crud.enums.Enum_Status;
import br.com.pet.crud.model.Animal;
import br.com.pet.crud.repository.PetRepository;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetsController {

    @Autowired
    private final PetRepository petRepository;

    public PetsController(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @GetMapping(value = "/")
    public String teste(){
        return "index";
    }

    // Listar todos os pets
    @GetMapping(value = "listarPets")
    @ResponseBody
    public ResponseEntity<?> listarPets(){
        List<Animal> animais = petRepository.findAll();
        if(animais.isEmpty()) {
            return new ResponseEntity<String>("Nenhum \'pet\' cadastrado!", HttpStatus.OK);
        }
        return new ResponseEntity<List<Animal>>(animais, HttpStatus.OK);
    }

    // Listar pets pelo Status do Cadastro
    @GetMapping(value = "listarStatusPet/{status}")
    @ResponseBody
    public ResponseEntity<List<Animal>> listarStatusPet(@RequestParam(name = "status") Enum_Status status){
        List<Animal> animais = petRepository.findByStatus(status);
        return new ResponseEntity<List<Animal>>(animais, HttpStatus.OK);
    }

    @GetMapping(value = "/listar")
    public String paginaListar(){
        return "listarStatusPet";
    }

    // Atualizar pet no banco
    @PutMapping(value = "atualizarPet")
    @ResponseBody
    public ResponseEntity<Animal> atualizarPet(@RequestBody Animal animal){
        animal = petRepository.saveAndFlush(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    // Atualizar pet no banco
    @PutMapping(value = "atualizarStatusPet")
    @ResponseBody
    public ResponseEntity<Animal> atualizarStatusPet(@RequestBody Animal animal){
        animal = petRepository.saveAndFlush(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    // Salvando os registros no banco
    @PostMapping(value = "salvarPet")
    @ResponseBody
    public ResponseEntity<Animal> salvarPet(@RequestBody Animal animal){
        animal = petRepository.saveAndFlush(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.CREATED);
    }

    // Deletar pet no banco
    @DeleteMapping(value ="deletarPet")
    @ResponseBody
    public ResponseEntity<String> deletarPet(@RequestParam Long id){
        petRepository.deleteById(id);
        return new ResponseEntity<String>("Registro deletado com sucesso!", HttpStatus.OK);
    }
}