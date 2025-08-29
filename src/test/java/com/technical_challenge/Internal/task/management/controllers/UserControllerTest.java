package com.technical_challenge.Internal.task.management.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technical_challenge.Internal.task.management.dto.UserCreateDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
// Usar o mesmo banco Mysql
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// application-test.properties
@ActiveProfiles("test")
class UserControllerTest {
    // Teste de Unidade

    @Autowired
    private MockMvc mvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informações estão invalidas")
    void createUserEmpty() throws Exception {
         var response = mvc.perform(post("/user"))
                .andReturn().getResponse();

         assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 201 quando informações estão validas")
    void createUser() throws Exception {
        UserCreateDTO dtoCreateUser = new UserCreateDTO();
        dtoCreateUser.setName("Ana Claudia");
        dtoCreateUser.setEmail("Ana@gmail.com");
        var response = mvc
                .perform(
                        post("/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dtoCreateUser))
                )
                .andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}