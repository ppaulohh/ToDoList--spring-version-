package com.example.demo.task.model;

import com.example.demo.task.dto.TaskDTO;
import com.example.demo.task.enumerate.Priority;
import com.example.demo.task.enumerate.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String responsible;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(nullable = false)
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task(String title, String responsible, String description, Priority priority, LocalDate deadline) {
        this.title = title;
        this.responsible = responsible;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.status = Status.Aberta;
    }

    public Task(String title, String responsible, String description, Priority priority, LocalDate deadline, Status status) {
    }

    public TaskDTO dto(){
        return new TaskDTO(this.title,this.responsible,this.description,this.priority,this.deadline);
    }

}
