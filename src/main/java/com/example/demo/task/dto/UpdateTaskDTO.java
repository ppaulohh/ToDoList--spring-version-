package com.example.demo.task.dto;

import com.example.demo.task.enumerate.Priority;
import com.example.demo.task.enumerate.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDTO {

    @JsonProperty("title")
    String title;

    @JsonProperty("responsible")
    String responsible;

    @JsonProperty("description")
    String description;

    @JsonProperty("priority")
    Priority priority;

    @JsonProperty("deadline")
    LocalDate deadline;

    @JsonProperty("status")
    Status status;


}
