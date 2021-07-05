package com.example.demo.task.controller;

import com.example.demo.task.dto.TaskDTO;
import com.example.demo.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getTasks(){
        return taskService.getTasks();
    }


    @PostMapping
    public String createTask(@RequestBody TaskDTO task){
        return taskService.createTask(task);
    }
}
