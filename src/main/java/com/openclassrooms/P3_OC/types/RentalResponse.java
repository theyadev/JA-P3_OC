package com.openclassrooms.P3_OC.types;

import java.util.List;

import com.openclassrooms.P3_OC.model.Rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponse {

    @Schema(description = "Rental's List", required = true)
    private List<Rental> rentals;

}