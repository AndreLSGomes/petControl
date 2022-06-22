package br.com.pet.crud.controllers;
import br.com.pet.crud.dto.AnimalDTO;
import br.com.pet.crud.model.Animal;
import br.com.pet.crud.repository.PetRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetsController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private AnimalDTO animalDTO;

    @GetMapping(value = "/")
    public String teste(){
        return "index";
    }

    // Listar todos os pets
    @GetMapping(value = "listarPets")
    @ResponseBody
    public ResponseEntity<List<AnimalDTO>> listarPets(){
        List<Animal> animal = petRepository.findAll();

        List<AnimalDTO> animalDTO = new ArrayList<AnimalDTO>();

        animal.forEach(items -> {
            List<Integer> list = calcularIdade(items.getDataNascimento());
            int ano   = list.get(0);
            int meses = list.get(1);
            int dias  = list.get(2);

            animalDTO.add(new AnimalDTO(items.getId(), items.getNome(), items.getDataNascimento(), items.getEspecieAnimal(), items.getPorteAnimal(),
                                        items.getStatusCadastro(), ano, meses, dias));
        });
        return ResponseEntity.ok(animalDTO);
    }

    /*
    // Listar pets pelo Status do Cadastro
    @GetMapping(value = "listarStatusPet")
    @ResponseBody
    public ResponseEntity<List<Animal>> listarStatusPet(@RequestParam(name = "status") Enum_StatusCadastro status){
        List<Animal> animais = petRepository.findByStatus(status);
        return new ResponseEntity<List<Animal>>(animais, HttpStatus.OK);
    }

    @GetMapping(value = "listapetsstatus")
    @ResponseBody
    public ResponseEntity<List<Pets>> listaPetsStatus(@RequestParam(name = "status") Enum_Status status){
        List<Pets> pets = petsRepository.listarPetsStatus(status);
        return new ResponseEntity<List<Pets>>(pets, HttpStatus.OK);

    }

    @GetMapping(value = "/listar")
    public String paginaListar(){
        return "listarStatusPet";
    }
*/
    // Atualizar pet no banco
    @PutMapping(value = "atualizarPet")
    @ResponseBody
    public ResponseEntity<Animal> atualizarPet(@RequestBody Animal animal){
        animal = petRepository.saveAndFlush(animal);
        return new ResponseEntity<Animal>(animal, HttpStatus.OK);
    }

    // Atualizar status do pet no banco
    @PutMapping(value = "atualizarStatusPet")
    @ResponseBody
    public ResponseEntity<Animal> atualizarStatusPet(@RequestParam Animal animal){
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

    private static List<Integer> calcularIdade(Date data) {
        int anos = 0;
        int meses = 0;
        int dias = 0;

        Calendar dataAtual;
        Calendar dataNascimento;

        dataAtual = Calendar.getInstance();
        dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(data);

        anos  = anos + (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));

        meses = meses + (dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH));

        dias  = dias + (dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH));

        if (dataAtual.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)) {
            if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                dias  = 30 + dias;
                meses = 12 + meses;
                anos  = anos - 1;
            }
        } else if (dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            if (dataAtual.get(Calendar.DAY_OF_MONTH) >= dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                meses = 12 + meses;
                anos  = anos - 1;
            } else if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                dias  = 30 + dias;
                meses = 12 + meses;
                anos  = anos - 1;
            }
        } else if (dataAtual.get(Calendar.MONTH) > dataNascimento.get(Calendar.MONTH)) {
            if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                dias  = 30 + dias;
                meses = meses - 1;
            }
        }
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(anos);
        lista.add(meses);
        lista.add(dias);
        return  lista;
    }

}