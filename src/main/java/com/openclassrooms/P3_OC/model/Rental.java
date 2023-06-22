package com.openclassrooms.P3_OC.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Builder
@Entity
@Table(name = "rentals")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Rental {

    @Schema(description = "Rental's id", required = true, example = "2")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "Rental's name", required = true, example = "Mansion")
    private String name;

    @Schema(description = "Rental's Surface", required = true, example = "300")
    private BigDecimal surface;

    @Schema(description = "Rental's price", required = true, example = "1896")
    private BigDecimal price;

    @Schema(description = "Rental's picture", required = true, example = "mansion.png")
    private String picture;

    @Schema(description = "Rental's description", required = true, example = "This is a beautiful mansion")
    private String description;

    @Schema(description = "Rental's creation date", required = true, example = "2021-01-01T00:00:00")
    @CreatedDate
    private LocalDateTime created_at;

    @Schema(description = "Rental's last update date", required = true, example = "2021-01-01T00:00:00")
    @LastModifiedDate
    private LocalDateTime updated_at;

    @Schema(description = "Rental's owner id", required = true, example = "1")
    private Integer owner_id;

}