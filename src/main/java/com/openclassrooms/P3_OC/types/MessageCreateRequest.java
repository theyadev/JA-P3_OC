package com.openclassrooms.P3_OC.types;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class MessageCreateRequest {

    @Schema(description = "Message's content", required = true, example = "Hello, I would like to rent your mansion.")
    private String message;

    @Schema(description = "Message's user id", required = true, example = "3")
    private Integer user_id;

    @Schema(description = "Message's rental id", required = true, example = "2")
    private Integer rental_id;

}
