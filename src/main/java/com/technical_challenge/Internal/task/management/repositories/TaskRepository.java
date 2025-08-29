package com.technical_challenge.Internal.task.management.repositories;

import com.technical_challenge.Internal.task.management.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>  {

}
