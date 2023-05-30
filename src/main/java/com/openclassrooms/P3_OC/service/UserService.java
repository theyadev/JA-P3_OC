package com.openclassrooms.P3_OC.service;

import com.openclassrooms.P3_OC.model.User;
import com.openclassrooms.P3_OC.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

}
