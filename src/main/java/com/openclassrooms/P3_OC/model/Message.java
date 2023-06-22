package com.openclassrooms.P3_OC.model;

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
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Message {

    @Schema(description = "Message's id", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "Message's content", required = true, example = "Hello")
    private String message;

    @Schema(description = "Message's creation date", required = true, example = "2021-01-01T00:00:00")
    @CreatedDate
    private LocalDateTime created_at;

    @Schema(description = "Message's last update date", required = true, example = "2021-01-01T00:00:00")
    @LastModifiedDate
    private LocalDateTime updated_at;

    @Schema(description = "Message's rental id", required = true, example = "2")
    private Integer rental_id;

    @Schema(description = "Message's user id", required = true, example = "3")
    private Integer user_id;

}