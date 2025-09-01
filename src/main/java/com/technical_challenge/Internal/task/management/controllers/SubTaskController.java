package com.technical_challenge.Internal.task.management.controllers;

import com.technical_challenge.Internal.task.management.dto.SubTaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.SubTaskResponseDTO;
import com.technical_challenge.Internal.task.management.services.SubTaskService;
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
@RequestMapping("/subTask")
public class SubTaskController {

    @Autowired
    SubTaskService subTaskService;

    @PostMapping
    public ResponseEntity<SubTaskResponseDTO> createSubTask(@Validated @RequestBody SubTaskCreateDTO dto){
        SubTaskResponseDTO savedSubTask = subTaskService.createSubTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSubTask);
    }

}
