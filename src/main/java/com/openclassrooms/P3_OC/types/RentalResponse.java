package com.openclassrooms.P3_OC.types;

import java.util.List;

import com.openclassrooms.P3_OC.model.Rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalResponse {

    private List<Rental> rentals;

}