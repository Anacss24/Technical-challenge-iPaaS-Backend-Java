package com.technical_challenge.Internal.task.management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class SubTaskCreateDTO {

    @NotBlank(message = "O titulo é obrigatório")
    private String titleSub;


    @Column
    private String descriptionSub;

    @NotNull(message = "É necessário associar a SubTarefa a uma tarefa")
    @JsonProperty("id_task")
    private UUID TaskId;


}
