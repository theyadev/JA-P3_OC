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
public class JwtResponse {

	@Schema(description = "User's token", required = true, example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQHRlc3"
			+ "IiwiaWF0IjoxNjE0NjI4NjQ4LCJleHAiOjE2MTQ2Mz")
	private String token;

}
