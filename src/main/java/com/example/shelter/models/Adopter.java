package com.example.shelter.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Adopter {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Animal> animals = new ArrayList<>();

    public Adopter() {
    }

    public Adopter(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
