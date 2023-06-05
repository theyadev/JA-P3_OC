package com.openclassrooms.P3_OC.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P3_OC.model.Message;
import com.openclassrooms.P3_OC.service.MessageService;
import com.openclassrooms.P3_OC.types.MessageCreateRequest;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> createMessage(@RequestBody MessageCreateRequest messageCreateRequest) {
        Message message = Message.builder()
                .message(messageCreateRequest.getMessage())
                .user_id(messageCreateRequest.getUser_id())
                .rental_id(messageCreateRequest.getRental_id())
                .build();

        return ResponseEntity.ok(messageService.createMessage(message));
    }

}