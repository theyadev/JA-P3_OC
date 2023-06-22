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

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(tags = { "rental" })
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

    @Operation(summary = "Get all rentals", description = "Get all rentals.", tags = { "rental" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rentals founds successfully.", content = @Content(schema = @Schema(implementation = RentalResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
    @GetMapping("")
    public ResponseEntity<RentalResponse> findAll() {
        List<Rental> rentals = rentalService.findAll();
        RentalResponse rentalResponse = new RentalResponse(rentals);
        return ResponseEntity.ok(rentalResponse);
    }

    @Operation(summary = "Get rental by id", description = "Get rental by id.", tags = { "rental" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rental found successfully.", content = @Content(schema = @Schema(implementation = Rental.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Integer id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @Operation(summary = "Create rental", description = "Create rental.", tags = { "rental" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rental created successfully.", content = @Content(schema = @Schema(implementation = Rental.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<RentalCreateResponse> createRental(
            @ModelAttribute @RequestBody RentalCreateRequest rentalCreateRequest) throws IOException {
        Rental rental = this.createRentalFromRequest(rentalCreateRequest);

        String picture = fileService.uploadPicture(rentalCreateRequest.getPicture());

        rental.setPicture(picture);

        if (rental.getPicture() != null) {

            rentalService.createRental(rental);

            return ResponseEntity.ok(new RentalCreateResponse("Successfully created"));

        }

        return ResponseEntity.badRequest().body(new RentalCreateResponse("Error while creating rental"));
    }

    @Operation(summary = "Update rental", description = "Update rental.", tags = { "rental" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rental updated successfully.", content = @Content(schema = @Schema(implementation = Rental.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Rental> updateRental(@PathVariable Integer id,
            @ModelAttribute @RequestBody RentalCreateRequest rentalUpdateRequest) {
        Rental rental = this.createRentalFromRequest(rentalUpdateRequest);

        return ResponseEntity.ok(rentalService.updateRental(id, rental));
    }

}
