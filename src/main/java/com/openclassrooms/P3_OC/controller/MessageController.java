package com.openclassrooms.P3_OC.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openclassrooms.P3_OC.model.Message;
import com.openclassrooms.P3_OC.model.Rental;
import com.openclassrooms.P3_OC.model.User;
import com.openclassrooms.P3_OC.service.MessageService;
import com.openclassrooms.P3_OC.service.RentalService;
import com.openclassrooms.P3_OC.service.UserService;
import com.openclassrooms.P3_OC.types.MessageCreateRequest;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @Autowired
    private RentalService rentalService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> createMessage(@RequestBody MessageCreateRequest messageCreateRequest) {
        Message message = new Message();

        User sender = userService.getUserById(messageCreateRequest.getUser_id());
        Rental rental = rentalService.getRentalById(messageCreateRequest.getRental_id());

        message.setUser(sender);
        message.setRental(rental);
        message.setMessage(messageCreateRequest.getMessage());

        return ResponseEntity.ok(messageService.createMessage(message));
    }

}