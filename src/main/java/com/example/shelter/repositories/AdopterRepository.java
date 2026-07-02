package com.example.shelter.repositories;

import com.example.shelter.models.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdopterRepository extends JpaRepository<Adopter, Integer> {
}
