package com.technical_challenge.Internal.task.management.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user", length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID userId;

    @Column(length = 255, nullable = false)
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Schema(example = "email@email.com.br")
    @Column(nullable = false, unique = true, length = 255)
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> task = new ArrayList<>();


}
