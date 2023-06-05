package com.openclassrooms.P3_OC.service;

import com.openclassrooms.P3_OC.model.Message;
import com.openclassrooms.P3_OC.repository.MessageRepository;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

}
