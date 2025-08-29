package com.technical_challenge.Internal.task.management.dto;

import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.Task;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskResponseDTO {

    private UUID id_task;
    private String title;
    private String description;
    private StatusTask status;
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;


    public TaskResponseDTO(Task task) {
        this.id_task = task.getTaskId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.creationDate = task.getCreationDate();
        this.completionDate = task.getCompletionDate();
    }
}
