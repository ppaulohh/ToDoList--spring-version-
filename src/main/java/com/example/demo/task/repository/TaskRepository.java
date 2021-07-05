package com.example.demo.task.repository;

import com.example.demo.task.enumerate.Status;
import com.example.demo.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByTitleOrDescription(String title,String description);
    List<Task> findByResponsible(String responsible);
    List<Task> findByStatus(Status status);
}
