package com.technical_challenge.Internal.task.management.dto;

import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.Task;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskResponseDTO {

    private UUID taskId;
    private String title;
    private String description;
    @Setter
    private StatusTask status;
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;
    private UUID userId;
    private String nomeUser;
    private String emailUser;


    public TaskResponseDTO(Task task) {
        this.taskId = task.getTaskId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.creationDate = task.getCreationDate();
        this.completionDate = task.getCompletionDate();
        this.userId = task.getUser().getUserId();
        this.nomeUser = task.getUser().getName();
        this.emailUser = task.getUser().getEmail();
    }

}
