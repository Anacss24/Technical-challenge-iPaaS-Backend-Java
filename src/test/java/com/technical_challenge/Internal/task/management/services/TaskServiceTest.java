package com.technical_challenge.Internal.task.management.services;


import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.SubTask;
import com.technical_challenge.Internal.task.management.models.Task;
import com.technical_challenge.Internal.task.management.models.User;
import com.technical_challenge.Internal.task.management.repositories.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.assertj.core.api.Assertions.*;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;


    @Test
    @DisplayName("Deve lançar exceção ao tentar concluir tarefa com sub-tarefas pendentes")
    void updateTaskStatus_ShouldThrowException_WhenSubTasksAreNotCompleted() {
        // Arrange
        UUID taskId = UUID.randomUUID();
        UUID userId = UUID.randomUUID();
        StatusTask newStatus = StatusTask.CONCLUIDA;

        User testUser = new User();
        testUser.setUserId(userId);

        Task existingTask = new Task();
        existingTask.setTaskId(taskId);
        existingTask.setUser(testUser);

        SubTask pendingSubTask = new SubTask();
        pendingSubTask.setStatusSub(StatusTask.PENDENTE);

        existingTask.getSubTask().add(pendingSubTask);


        pendingSubTask.setTask(existingTask);


        when(taskRepository.findById(taskId)).thenReturn(Optional.of(existingTask));


        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> taskService.updateTaskStatus(taskId, newStatus)
        );

        assertThat(exception.getMessage()).isEqualTo("Não é possível concluir a tarefa principal pois existem sub-tarefas pendentes.");

        verify(taskRepository, never()).save(any(Task.class));
    }
}