package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.TaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.TaskResponseDTO;
import com.technical_challenge.Internal.task.management.models.Task;
import com.technical_challenge.Internal.task.management.models.User;
import com.technical_challenge.Internal.task.management.repositories.TaskRepository;
import com.technical_challenge.Internal.task.management.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskResponseDTO createTask (TaskCreateDTO dto){
        User user = userRepository.findById(dto.getUser())
                .orElseThrow(() -> new IllegalArgumentException("O Usuário com ID " + dto.getUser() + "não encotrado"));

        Task newTask = new Task();
        newTask.setTitle(dto.getTitle());
        newTask.setDescription(dto.getDescription());
        newTask.setUser(user);

        Task savedTask = taskRepository.save(newTask);

        return new TaskResponseDTO(savedTask);

    }
}
