package com.technical_challenge.Internal.task.management.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

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

}
