package com.technical_challenge.Internal.task.management.dto;

import com.technical_challenge.Internal.task.management.models.StatusTask;
import com.technical_challenge.Internal.task.management.models.SubTask;
import com.technical_challenge.Internal.task.management.models.Task;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class SubTaskResponseDTO {

    private UUID subtaskId;
    private String titleSub;
    private String descriptionSub;
    @Setter
    private StatusTask statusSub;
    private LocalDateTime creationDateSub;
    private LocalDateTime completionDateSub;
    private UUID idTask;
    private String taskTitle;
    private String taskDescription;


    public SubTaskResponseDTO(SubTask subTask) {
        this.subtaskId = subTask.getSubTaskId();
        this.titleSub = subTask.getTitleSub();
        this.descriptionSub = subTask.getDescriptionSub();
        this.statusSub = subTask.getStatusSub();
        this.creationDateSub = subTask.getCreationDateSub();
        this.completionDateSub = subTask.getCompletionDateSub();
        this.idTask = subTask.getTask().getTaskId();
        this.taskTitle = subTask.getTask().getTitle();
        this.taskDescription = subTask.getTask().getDescription();
    }

}
