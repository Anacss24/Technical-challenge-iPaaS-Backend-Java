package com.technical_challenge.Internal.task.management.controllers;

import com.technical_challenge.Internal.task.management.dto.UserCreateDTO;
import com.technical_challenge.Internal.task.management.dto.UserResponseDTO;
import com.technical_challenge.Internal.task.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@Validated @RequestBody UserCreateDTO dto){
        UserResponseDTO userSaved = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO>searchId(@PathVariable UUID id){
        return userService.searchId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
