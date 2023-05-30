package com.openclassrooms.P3_OC.types;

import lombok.Data;

@Data
public class MessageCreateRequest {

    private String message;
    private Integer user_id;
    private Integer rental_id;

}
