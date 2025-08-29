package com.technical_challenge.Internal.task.management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.technical_challenge.Internal.task.management.models.Task;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class TaskCreateDTO {

    @Getter
    @Setter
    @NotBlank(message = "O titulo é obrigatório")
    private String title;

    @Setter
    @Getter
    @Column
    private String description;


    @NotNull(message = "É necessário associar a tarefa a um usuário")
    @JsonProperty("id_user")
    private UUID userId;


    public TaskCreateDTO() {
    }

    public TaskCreateDTO(Task task) {
        this.title = title;
        this.description = description;
    }

    public UUID getUser() {
        return userId;
    }

    public void setUser(UUID user) {
    }


}
