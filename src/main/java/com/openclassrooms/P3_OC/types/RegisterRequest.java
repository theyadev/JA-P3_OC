package com.openclassrooms.P3_OC.types;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {

    @NonNull
    private String name;
    @NonNull

    private String email;
    @NonNull
    private String password;

}
