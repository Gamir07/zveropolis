package ru.skypro.zveropolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.zveropolis.model.Pet;
@Repository
public interface PetRepository extends JpaRepository<Pet,Long>  {
    Pet findById(long id);
}
