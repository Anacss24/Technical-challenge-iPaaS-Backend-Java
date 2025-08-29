package com.technical_challenge.Internal.task.management.dto;

import com.technical_challenge.Internal.task.management.models.User;
import lombok.Data;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class UserResponseDTO {

    private UUID userId;
    private String name;
    private String email;
    private List<TaskResponseDTO> tasks;


    public UserResponseDTO(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.tasks = user.getTask().stream()
                .map(TaskResponseDTO::new)
                .collect(Collectors.toList());
    }
}
