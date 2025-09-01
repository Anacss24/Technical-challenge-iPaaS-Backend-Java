package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.SubTaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.SubTaskResponseDTO;
import com.technical_challenge.Internal.task.management.models.SubTask;
import com.technical_challenge.Internal.task.management.models.Task;
import com.technical_challenge.Internal.task.management.repositories.SubTaskRepository;
import com.technical_challenge.Internal.task.management.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SubTaskService {

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    TaskRepository taskRepository;

    public SubTaskResponseDTO createSubTask(SubTaskCreateDTO dto) {
        Task task = taskRepository.findById(dto.getTaskId())
                .orElseThrow(() -> new IllegalArgumentException("A Tarefa com ID " + dto.getTaskId() + "não encontrado"));

        SubTask newSubTask = new SubTask();
        newSubTask.setTitleSub(dto.getTitleSub());
        newSubTask.setDescriptionSub(dto.getDescriptionSub());
        newSubTask.setTask(task);
        SubTask savedSubTask = subTaskRepository.save(newSubTask);
        return new SubTaskResponseDTO(savedSubTask);
    }

}
