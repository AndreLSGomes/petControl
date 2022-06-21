package br.com.pet.crud.repository;

import java.util.Collection;
import java.util.List;

import br.com.pet.crud.enums.Enum_Status;
import br.com.pet.crud.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Animal, Long>{
    @Query(value = "SELECT * FROM animal a WHERE a.cadastro_ativo = ?1", nativeQuery = true)
    List<Animal> findByStatus(Enum_Status status);
}