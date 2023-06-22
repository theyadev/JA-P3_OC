package com.openclassrooms.P3_OC.types;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NonNull;

@Data
public class MessageResponse {

    @Schema(description = "Message", required = true)
    @NonNull
    private String message;

}
