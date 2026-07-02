package com.example.shelter.controllers;


import com.example.shelter.models.Adopter;
import com.example.shelter.models.Animal;
import com.example.shelter.repositories.AdopterRepository;
import com.example.shelter.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdopterRepository adopterRepository;

    @GetMapping
    public String renderForm() {

        return """
                <h1>Animal Intake Form</h1>
                
                <form method="post">
                <label>Animal Name:
                <input type="text" name="name">
                <label>Animal species:
                <input type="text" name="species">
                <label>Animal age:
                <input type="text" name="age">
                <input type="submit">
                </form>
                
                """;
    }

    @GetMapping("/adopt")
    public String renderAdoptForm() {

        return """
                <h1>Adoption Record</h1>
                
                <form method="post">
                <label>Adopter Name:
                <input type="text" name="name">
                <label>Adopter phone number:
                <input type="text" name="phone number">
                <label>Animal id:
                <input type="text" name="id">
                <input type="submit">
                </form>
                
                """;
    }

    @PostMapping("/adopt")
    public String handleAdopter(Adopter adopter) {
        adopterRepository.save(adopter);
        return adopter.getName() + " has been added.";
    }

    //model binding
    @PostMapping
    public String handleForm(Animal animal)  {
        animalRepository.save(animal);
        return animal.getName() + " has been added.";
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable int id){
        return animalRepository.findById(id).orElse(null);
    }
}
