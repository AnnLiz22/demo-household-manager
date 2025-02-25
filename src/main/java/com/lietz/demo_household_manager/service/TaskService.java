package com.lietz.demo_household_manager.service;

import com.lietz.demo_household_manager.model.Category;
import com.lietz.demo_household_manager.model.Task;
import com.lietz.demo_household_manager.model.User;
import com.lietz.demo_household_manager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByAssignee(User assignee){
        return taskRepository.findByAssignee(assignee);
    }

    public List<Task> getTasksByExecutor(User executor){
        return taskRepository.findByExecutor(executor);
    }

    public List<Task> getTasksByCategory(Category category){
        return taskRepository.findByCategory(category);
    }

    public List<Task> getCompletedTasks(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> getUncompletedTasks(){
        return taskRepository.findByCompletedFalse();
    }

    public Task completeTask(Long id) {
        Task task = getTaskById(id);
        if (task != null) {
            task.setCompleted(true);
            task.setCompletedAt(LocalDateTime.now());
            return taskRepository.save(task);
        }
        return null;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
