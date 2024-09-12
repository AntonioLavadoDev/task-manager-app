package com.alav.task_manager.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.alav.task_manager.model.Task;
import com.alav.task_manager.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    
    public TaskServiceImpl (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task createTask(Task task) {
    // Crea una nueva tarea usando el constructor que asigna createdAt
    Task newTask = new Task(task.getTitle(), task.getDescription());
    return taskRepository.save(newTask);
}


    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }

}
