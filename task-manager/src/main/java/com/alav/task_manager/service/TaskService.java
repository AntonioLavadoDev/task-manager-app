package com.alav.task_manager.service;

import java.util.List;
import java.util.Optional;

import com.alav.task_manager.model.Task;

public interface TaskService {

    List<Task> findAllTasks();
    Optional<Task> findTaskById(Long id);
    Task createTask (Task task);
    Task updateTask (Long id,  Task task);
    void deleteTaskById(Long id);

    
} 

    
    



