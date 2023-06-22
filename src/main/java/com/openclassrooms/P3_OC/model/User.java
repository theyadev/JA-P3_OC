package com.openclassrooms.P3_OC.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Schema(description = "User's id", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Schema(description = "User's name", required = true, example = "John")
    private String name;

    @Schema(description = "User's email", required = true, example = "john@test.com")
    private String email;

    @Schema(description = "User's password", required = true, example = "password")
    private String password;

    @Schema(description = "User's creation date", required = true, example = "2021-01-01T00:00:00")
    @CreatedDate
    private LocalDateTime created_at;

    @Schema(description = "User's last update date", required = true, example = "2021-01-01T00:00:00")
    @LastModifiedDate
    private LocalDateTime updated_at;

}