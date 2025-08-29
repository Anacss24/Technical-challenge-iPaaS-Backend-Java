package com.technical_challenge.Internal.task.management.controllers;


import com.technical_challenge.Internal.task.management.dto.TaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.TaskResponseDTO;
import com.technical_challenge.Internal.task.management.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@Validated @RequestBody TaskCreateDTO dto){
        TaskResponseDTO savedTask = taskService.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }
}
