package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.UserCreateDTO;
import com.technical_challenge.Internal.task.management.dto.UserResponseDTO;
import com.technical_challenge.Internal.task.management.models.User;
import com.technical_challenge.Internal.task.management.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create (UserCreateDTO dto) {
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }
        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setName(dto.getName());
        User userSaved = userRepository.save(newUser);
        return new UserResponseDTO(userSaved);
    }

    public Optional<UserResponseDTO>searchId(UUID id){
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserResponseDTO::new);
    }


}
