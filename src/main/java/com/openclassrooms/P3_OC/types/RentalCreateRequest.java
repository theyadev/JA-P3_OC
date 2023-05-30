package com.openclassrooms.P3_OC.types;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalCreateRequest {

    private String name;
    private BigDecimal surface;
    private MultipartFile picture;
    private BigDecimal price;
    private String description;

}