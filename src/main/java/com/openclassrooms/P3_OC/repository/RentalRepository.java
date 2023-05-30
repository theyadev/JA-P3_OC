package com.openclassrooms.P3_OC.repository;

import com.openclassrooms.P3_OC.model.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {
}