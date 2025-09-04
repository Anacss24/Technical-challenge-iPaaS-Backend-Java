package com.technical_challenge.Internal.task.management.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "task")
public class Task {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_task", length = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID taskId;

    @Column(nullable = false)
    @NotBlank(message = "O titulo é obrigatório")
    private String title;

    @Column
    private String description;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private StatusTask status = StatusTask.PENDENTE;

    @CreatedDate
    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    @Getter
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SubTask> subTask = new ArrayList<>();


    public void setStatus(StatusTask status) {
        if (status == StatusTask.CONCLUIDA) {
            this.completionDate = LocalDateTime.now();
        } else {
            this.completionDate = null;
        }

        this.status = status;
    }
    @Transient
    public boolean isAllSubTasksCompleted() {
        if (this.subTask == null || this.subTask.isEmpty()) {
            return true;
        }
        return this.subTask.stream()
                .allMatch(st -> st.getStatusSub() == StatusTask.CONCLUIDA);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                '}';
    }

}

