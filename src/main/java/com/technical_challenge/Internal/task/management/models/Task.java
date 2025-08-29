package com.technical_challenge.Internal.task.management.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_task",length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID taskId;

    @Column(nullable = false)
    @NotBlank(message = "O titulo é obrigatório")
    private String title;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusTask status = StatusTask.PENDENTE;

    @CreatedDate
    @Column(name = "creation_date",nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

   @ManyToOne
   @JoinColumn(name = "id_user")
   private User user;

   public void setStatus(StatusTask newStatus){
       if(newStatus == StatusTask.CONCLUIDA){
           this.completionDate = LocalDateTime.now();
       } else {
           this.completionDate = null;
       }
   }

}

