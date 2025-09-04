package com.technical_challenge.Internal.task.management.dto;


import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.Task;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
public class TaskResponseDTO {

    private UUID taskId;
    private String title;
    private String description;
    @Setter
    private StatusTask status;
    private LocalDateTime creationDate;
    private LocalDateTime completionDate;
    private UUID idUser;
    private List<SubTaskResponseDTO> subTask;



    public TaskResponseDTO(Task task) {
        this.taskId = task.getTaskId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.creationDate = task.getCreationDate();
        this.completionDate = task.getCompletionDate();
        this.idUser = task.getUser().getUserId();
        this.subTask = task.getSubTask().stream()
                .map(SubTaskResponseDTO::new)
                .collect(Collectors.toList());

    }

    public TaskResponseDTO() {
    }
}
