package com.openclassrooms.P3_OC.types;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalCreateRequest {

    @Schema(description = "Rental's name", required = true, example = "Rental name")
    private String name;

    @Schema(description = "Rental's surface", required = true, example = "250")
    private BigDecimal surface;

    @Schema(description = "Rental's picture", required = true, example = "mansion.png")
    private MultipartFile picture;

    @Schema(description = "Rental's price", required = true, example = "1696")
    private BigDecimal price;

    @Schema(description = "Rental's description", required = true, example = "This is a beautiful mansion.")
    private String description;

}