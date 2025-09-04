package com.technical_challenge.Internal.task.management.controllers;


import com.technical_challenge.Internal.task.management.dto.TaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.TaskResponseDTO;
import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Validated @RequestBody TaskCreateDTO dto) {
        TaskResponseDTO savedTask = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
    @RequestMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> searchId(@PathVariable UUID id) {
        Optional<TaskResponseDTO> dtoOptional = taskService.searchTaskId(id);
        return dtoOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> listByStatus(@RequestParam StatusTask status) {
        List<TaskResponseDTO> tasks = taskService.taskListByStatus(status);
        return ResponseEntity.ok(tasks);
    }

    @PatchMapping(value = "/{id}/status")
    public ResponseEntity<TaskResponseDTO> updateStatus(@PathVariable UUID id, @Validated @RequestBody TaskResponseDTO statusDto) {
        TaskResponseDTO taskUpdateDTO = taskService.updateTaskStatus(id, statusDto.getStatus());
        return ResponseEntity.ok(taskUpdateDTO);
    }

}
