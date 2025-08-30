package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.UserCreateDTO;
import com.technical_challenge.Internal.task.management.dto.UserResponseDTO;
import com.technical_challenge.Internal.task.management.models.User;
import com.technical_challenge.Internal.task.management.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(UserCreateDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado: " + dto.getEmail());
        }
        User newUser = new User();
        newUser.setEmail(dto.getEmail());
        newUser.setName(dto.getName());
        User userSaved = userRepository.save(newUser);
        return new UserResponseDTO(userSaved);
    }

    public Optional<UserResponseDTO> searchId(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário com ID" + id + "não foi encontrado"));
        return Optional.of(new UserResponseDTO(user));
    }

    public List<UserResponseDTO> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserResponseDTO::new)
                .collect(Collectors.toList());
    }
}
