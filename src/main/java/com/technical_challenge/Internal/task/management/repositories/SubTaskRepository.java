package com.technical_challenge.Internal.task.management.repositories;

import com.technical_challenge.Internal.task.management.models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubTaskRepository extends JpaRepository <SubTask, UUID> {
}
