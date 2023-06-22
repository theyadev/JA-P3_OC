package com.openclassrooms.P3_OC.types;

import lombok.Data;
import lombok.NonNull;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class RegisterRequest {

    @Schema(description = "User's name", required = true, example = "John")
    @NonNull
    private String name;
    @NonNull

    @Schema(description = "User's email", required = true, example = "john@test.com")
    private String email;

    @Schema(description = "User's password", required = true, example = "password")
    @NonNull
    private String password;

}
