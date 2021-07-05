package com.example.demo.task.service;

import com.example.demo.task.dto.TaskDTO;
import com.example.demo.task.model.Task;
import com.example.demo.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream().map(Task::dto).collect(Collectors.toList());
    }

    public String createTask(TaskDTO taskDto){
        taskRepository.save(taskDto.model());
        return "deu certo brother";
    }

}
