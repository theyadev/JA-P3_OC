package com.openclassrooms.P3_OC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P3_OC.model.Rental;
import com.openclassrooms.P3_OC.model.User;
import com.openclassrooms.P3_OC.service.RentalService;
import com.openclassrooms.P3_OC.service.UserService;
import com.openclassrooms.P3_OC.types.RentalCreateRequest;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
    private UserService userService;
    
    private Rental createRentalFromRequest(RentalCreateRequest rentalCreateRequest) {
        Rental rental = new Rental();

        User owner = userService.getUserById(1);

        rental.setName(rentalCreateRequest.getName());
        rental.setSurface(rentalCreateRequest.getSurface());
        rental.setPrice(rentalCreateRequest.getPrice());
        rental.setDescription(rentalCreateRequest.getDescription()); 
        rental.setOwner(owner);

        return rental;
    }

    @GetMapping("")
    public ResponseEntity<List<Rental>> findAll() {
        return  ResponseEntity.ok(rentalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Integer id) {
        return  ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Rental> createRental(@ModelAttribute RentalCreateRequest rentalCreateRequest) {
        Rental rental = this.createRentalFromRequest(rentalCreateRequest);

        return ResponseEntity.ok(rentalService.createRental(rental));

    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Rental> updateRental(@PathVariable Integer id, @ModelAttribute RentalCreateRequest rentalUpdateRequest) {
        Rental rental = this.createRentalFromRequest(rentalUpdateRequest);

        return  ResponseEntity.ok(rentalService.updateRental(id, rental));
    }

}