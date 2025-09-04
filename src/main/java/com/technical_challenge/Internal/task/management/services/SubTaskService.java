package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.SubTaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.SubTaskResponseDTO;
import com.technical_challenge.Internal.task.management.dto.TaskResponseDTO;
import com.technical_challenge.Internal.task.management.dto.UserResponseDTO;
import com.technical_challenge.Internal.task.management.exceptions.IdNotFoundException;
import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.SubTask;
import com.technical_challenge.Internal.task.management.models.Task;
import com.technical_challenge.Internal.task.management.repositories.SubTaskRepository;
import com.technical_challenge.Internal.task.management.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubTaskService {

    @Autowired
    SubTaskRepository subTaskRepository;

    @Autowired
    TaskRepository taskRepository;

    public SubTaskResponseDTO createSubTask(SubTaskCreateDTO dto, UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() ->  new IdNotFoundException());

        SubTask newSubTask = new SubTask();
        newSubTask.setTitleSub(dto.getTitleSub());
        newSubTask.setDescriptionSub(dto.getDescriptionSub());
        newSubTask.setTask(task);

        SubTask savedSubTask = subTaskRepository.save(newSubTask);
        return new SubTaskResponseDTO(savedSubTask);
    }

    public List<SubTaskResponseDTO> findSubTasksByTaskId(UUID taskid) {
        List<SubTask> subTasks = subTaskRepository.findByTaskTaskId(taskid);
        return subTasks.stream()
                .map(subTask -> new SubTaskResponseDTO(subTask)) // ou .map(SubTaskResponseDTO::new)
                .collect(Collectors.toList());
    }

    public SubTaskResponseDTO updateSubTaskStatus(UUID id, StatusTask status) {
        SubTask subTask = subTaskRepository.findById(id)
                .orElseThrow(() ->  new IdNotFoundException());

        subTask.setStatusSub(status);
        SubTask updateSubTask = subTaskRepository.save(subTask);
        return new SubTaskResponseDTO(updateSubTask);
    }

}
