package com.openclassrooms.P3_OC.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P3_OC.model.Rental;
import com.openclassrooms.P3_OC.service.AuthService;
import com.openclassrooms.P3_OC.service.FileService;
import com.openclassrooms.P3_OC.service.RentalService;
import com.openclassrooms.P3_OC.types.RentalCreateRequest;
import com.openclassrooms.P3_OC.types.RentalCreateResponse;
import com.openclassrooms.P3_OC.types.RentalResponse;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @Autowired
	private AuthService authService;

    @Autowired
    private FileService fileService;
    
    private Rental createRentalFromRequest(RentalCreateRequest rentalCreateRequest) {
        Rental rental = new Rental();

        rental.setName(rentalCreateRequest.getName());
        rental.setSurface(rentalCreateRequest.getSurface());
        rental.setPrice(rentalCreateRequest.getPrice());
        rental.setDescription(rentalCreateRequest.getDescription()); 
        rental.setOwner_id(authService.me().getId());    

        return rental;
    }

    @GetMapping("")
    public ResponseEntity<RentalResponse> findAll() {
        List<Rental> rentals = rentalService.findAll();
        RentalResponse rentalResponse =  new RentalResponse(rentals);
        return  ResponseEntity.ok(rentalResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Integer id) {
        return  ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RentalCreateResponse> createRental(@ModelAttribute RentalCreateRequest rentalCreateRequest) throws IOException {
        Rental rental = this.createRentalFromRequest(rentalCreateRequest);

        String picture = fileService.uploadPicture(rentalCreateRequest.getPicture());

        rental.setPicture(picture);
             
        if (rental.getPicture() != null) {

            rentalService.createRental(rental);

            return ResponseEntity.ok(new RentalCreateResponse("Successfully created"));

        } 

        return ResponseEntity.badRequest().body(new RentalCreateResponse("Error while creating rental"));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Rental> updateRental(@PathVariable Integer id, @ModelAttribute RentalCreateRequest rentalUpdateRequest) {
        Rental rental = this.createRentalFromRequest(rentalUpdateRequest);

        return  ResponseEntity.ok(rentalService.updateRental(id, rental));
    }

}