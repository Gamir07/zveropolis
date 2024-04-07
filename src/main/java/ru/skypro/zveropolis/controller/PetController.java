package ru.skypro.zveropolis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.zveropolis.model.Pet;
import ru.skypro.zveropolis.repository.PetRepository;

import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired

    private PetRepository petRepository;

    @PostMapping("/add")
    public void addPet(Pet pet) {
        petRepository.save(pet);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity <Pet> getPet(@PathVariable long id) {
       return ResponseEntity.ok(petRepository.findById(id));
    }
}
