package com.technical_challenge.Internal.task.management.services;

import com.technical_challenge.Internal.task.management.dto.TaskCreateDTO;
import com.technical_challenge.Internal.task.management.dto.TaskResponseDTO;
import com.technical_challenge.Internal.task.management.dto.UserResponseDTO;
import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.Task;
import com.technical_challenge.Internal.task.management.models.User;
import com.technical_challenge.Internal.task.management.repositories.TaskRepository;
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
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskResponseDTO createTask(TaskCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("O Usuário com ID " + dto.getUserId() + "não encotrado"));

        Task newTask = new Task();
        newTask.setTitle(dto.getTitle());
        newTask.setDescription(dto.getDescription());
        newTask.setUser(user);
        Task savedTask = taskRepository.save(newTask);
        return new TaskResponseDTO(savedTask);
    }

    public Optional<TaskResponseDTO> searchTaskId(UUID id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID" + id + "não foi encontrado"));
        return Optional.of(new TaskResponseDTO(task));
    }

    public TaskResponseDTO updateTaskStatus(UUID id, StatusTask status) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa com ID" + id + "não foi encontrado"));

        if(status == StatusTask.CONCLUIDA){
            if(!task.isAllSubTasksCompleted()){
                throw new IllegalStateException("Não é possível concluir a tarefa principal pois existem sub-tarefas pendentes.");
            }
        }

        task.setStatus(status);
        Task updateTask = taskRepository.save(task);
        return new TaskResponseDTO(updateTask);
    }

    public List<TaskResponseDTO> taskListByStatus(StatusTask status) {
        if (!taskRepository.existsByStatus(status)) {
            throw new IllegalArgumentException("Status " + status + " não encontrado em nenhuma tarefa");
        }

        List<Task> tasks = taskRepository.findByStatus(status);
        return tasks.stream()
                .map(TaskResponseDTO::new)
                .collect(Collectors.toList());
    }

}



