package com.example.demo.task.service;

import com.example.demo.task.dto.TaskDTO;
import com.example.demo.task.dto.UpdateTaskDTO;
import com.example.demo.task.enumerate.Status;
import com.example.demo.task.model.Task;
import com.example.demo.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public List<TaskDTO> getTasks() {
        return taskRepository.findByStatus(Status.Aberta).stream().map(Task::dto).collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if(task.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }

        return task.get().dto();
    }

    @Transactional
    public String createTask(TaskDTO taskDto){
        taskRepository.save(taskDto.model());
        return "The insertion was successful";
    }

    @Transactional
    public String updateTask(UpdateTaskDTO taskDto, Long id){
        Optional<Task> att = taskRepository.findById(id);
        if(att.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
        Task update = att.get();

        if(taskDto.getTitle()!=null)
            update.setTitle(taskDto.getTitle());

        if(taskDto.getDescription()!=null)
            update.setDescription(taskDto.getDescription());

        if(taskDto.getResponsible()!=null)
            update.setResponsible(taskDto.getResponsible());

        if(taskDto.getPriority()!=null)
            update.setPriority(taskDto.getPriority());

        if(taskDto.getDeadline()!=null)
            update.setDeadline(taskDto.getDeadline());

        if(taskDto.getStatus()!=null)
            update.setStatus(Status.Fechada);

        taskRepository.save(update);

        return "database has successfully been updated";
    }

    @Transactional
    public String deleteTask(Long id){

        Optional<Task> del = taskRepository.findById(id);

        if(del.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }

        taskRepository.delete(del.get());
        return "Your task has successfully been deleted";
    }

}
