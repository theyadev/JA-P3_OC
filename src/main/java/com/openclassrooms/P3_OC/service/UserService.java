package com.openclassrooms.P3_OC.service;

import com.openclassrooms.P3_OC.model.User;
import com.openclassrooms.P3_OC.repository.UserRepository;
import com.openclassrooms.P3_OC.types.UserResponse;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null)
            return null;

        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setName(user.getName());
        userResponse.setCreated_at(user.getCreated_at());
        userResponse.setUpdated_at(user.getUpdated_at());

        return userResponse;
    }

}
