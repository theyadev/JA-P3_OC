package com.openclassrooms.P3_OC.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalCreateResponse {

    @Schema(description = "Response Message", required = true, example = "Rental created successfully.")
    private String message;
}
