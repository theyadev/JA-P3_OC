package com.openclassrooms.P3_OC.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P3_OC.model.Message;
import com.openclassrooms.P3_OC.service.MessageService;
import com.openclassrooms.P3_OC.types.MessageCreateRequest;
import com.openclassrooms.P3_OC.types.MessageResponse;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Api(tags = { "message" })
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Operation(summary = "Create a new message", description = "Create a new message as the current user.", tags = {
            "message" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message created successfully.", content = @Content(schema = @Schema(implementation = Message.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content) })
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageCreateRequest messageCreateRequest) {
        Message message = Message.builder()
                .message(messageCreateRequest.getMessage())
                .user_id(messageCreateRequest.getUser_id())
                .rental_id(messageCreateRequest.getRental_id())
                .build();

        messageService.createMessage(message);

        return ResponseEntity.ok(new MessageResponse("Message sent successfully."));
    }

}