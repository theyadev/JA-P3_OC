package com.openclassrooms.P3_OC.service;

import com.openclassrooms.P3_OC.model.Rental;
import com.openclassrooms.P3_OC.repository.RentalRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    public Rental getRentalById(Integer id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public Rental updateRental(Integer id, Rental rental) {
        Rental rentalToUpdate = rentalRepository.findById(id).orElse(null);

        rentalToUpdate.setName(rental.getName());
        rentalToUpdate.setSurface(rental.getSurface());
        rentalToUpdate.setPrice(rental.getPrice());
        rentalToUpdate.setDescription(rental.getDescription());
        
        return rentalRepository.save(rentalToUpdate);
    }

}
