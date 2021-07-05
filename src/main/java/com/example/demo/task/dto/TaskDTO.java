package com.example.demo.task.dto;

import com.example.demo.task.enumerate.Priority;
import com.example.demo.task.model.Task;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    @JsonProperty("title")
    @NotNull(message = "title cannot be absent")
    @NotBlank(message = "title cannot be empty")
     String title;

    @JsonProperty("responsible")
    @NotNull(message = "responsible cannot be absent")
    @NotBlank(message = "responsible cannot be empty")
    String responsible;

    @JsonProperty("description")
    String description;

    @JsonProperty("priority")
    @NotNull(message = "priority can not be absent")
    Priority priority;

    @JsonProperty("deadline")
    @NotNull(message = "deadline can not be absent")
    LocalDate deadline;

    public Task model(){
        return new Task(this.title,this.responsible,this.description,this.priority,this.deadline);
    }
}
