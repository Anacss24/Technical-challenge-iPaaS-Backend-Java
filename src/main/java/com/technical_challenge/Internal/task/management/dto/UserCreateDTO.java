package com.technical_challenge.Internal.task.management.dto;

import com.technical_challenge.Internal.task.management.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UserCreateDTO {
    @NotBlank(message = "O nome é obrigatório.")
    private String name;

    @Email(message = "Deve ser um email válido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    public UserCreateDTO(){
    }

    public UserCreateDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

}


