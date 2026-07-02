package com.example.shelter.models;

import jakarta.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String species;
    private int age;

    @ManyToOne
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    public Animal() {
    }

    public Animal(int id, String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }
}
