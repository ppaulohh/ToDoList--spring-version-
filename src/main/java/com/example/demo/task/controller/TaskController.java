package com.example.demo.task.controller;

import com.example.demo.task.dto.TaskDTO;
import com.example.demo.task.dto.UpdateTaskDTO;
import com.example.demo.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }


    @PostMapping
    public String createTask(@Valid @RequestBody TaskDTO task){
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public String updateTask(@RequestBody UpdateTaskDTO att, @PathVariable Long id){
        return taskService.updateTask(att,id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }

}
