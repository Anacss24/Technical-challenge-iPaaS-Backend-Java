package com.technical_challenge.Internal.task.management.controllers;

import com.technical_challenge.Internal.task.management.dto.SubTaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.SubTaskResponseDTO;
import com.technical_challenge.Internal.task.management.services.SubTaskService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/task")
public class SubTaskController {

    @Autowired
    SubTaskService subTaskService;

    @PostMapping("/{taskId}/subtask")
    public ResponseEntity<SubTaskResponseDTO> createSubTask(@Validated @RequestBody SubTaskCreateDTO dto, @PathVariable UUID taskId ){
        SubTaskResponseDTO savedSubTask = subTaskService.createSubTask(dto,taskId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubTask);
    }

    @GetMapping("/{taskId}/subtask")
    public ResponseEntity<List<SubTaskResponseDTO>> searchTasksById(@Validated @PathVariable UUID taskId){
        List<SubTaskResponseDTO> tasksById = subTaskService.findSubTasksByTaskId(taskId);
        return ResponseEntity.ok(tasksById);
    }
    @PatchMapping(value = "/subtask/{id}/status")
    public ResponseEntity<SubTaskResponseDTO> updateStatus(@PathVariable UUID id, @RequestBody SubTaskResponseDTO statusDto) {
        SubTaskResponseDTO subTaskUpdate = subTaskService.updateSubTaskStatus(id, statusDto.getStatusSub());
        return ResponseEntity.ok(subTaskUpdate);
    }


}
