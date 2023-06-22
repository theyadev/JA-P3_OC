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
public class JwtRequest {

	@Schema(description = "User's email", required = true, example = "john@test.com")
	private String email;

	@Schema(description = "User's password", required = true, example = "password")
	private String password;

}
