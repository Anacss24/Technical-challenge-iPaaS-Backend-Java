package com.technical_challenge.Internal.task.management.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sub_task")
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_sub_task", length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID subTaskId;

    @Column
    @NotBlank(message = "O titulo é obrigatório")
    private String titleSub;

    @Column
    private String descriptionSub;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusTask statusSub = StatusTask.PENDENTE;

    @CreatedDate
    @Column(name = "creation_date_sub", nullable = false, updatable = false)
    private LocalDateTime creationDateSub;

    @Column(name = "completion_date_sub")
    private LocalDateTime completionDateSub;

    @Getter
    @ManyToOne
    @JoinColumn(name = "id_task")
    private Task task;

    public void setStatusSub(StatusTask statusSub) {
        if(statusSub == StatusTask.CONCLUIDA){
            this.completionDateSub = LocalDateTime.now();
        } else {
            this.completionDateSub = null;
        }
        this.statusSub = statusSub;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "subTaskId=" + subTaskId +
                ", titleSub='" + titleSub + '\'' +
                ", taskId=" + (task != null ? task.getTaskId() : null) +
                '}';
    }
}
