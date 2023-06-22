package com.openclassrooms.P3_OC.types;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @Schema(description = "User's id", required = true, example = "1")
    private Integer id;

    @Schema(description = "User's name", required = true, example = "John")
    private String name;

    @Schema(description = "User's email", required = true, example = "john@test.com")
    private String email;

    @Schema(description = "User's creation date", required = true, example = "2021-02-01T00:00:00.000+00:00")
    private LocalDateTime created_at;

    @Schema(description = "User's last update date", required = true, example = "2021-02-01T00:00:00.000+00:00")
    private LocalDateTime updated_at;

}