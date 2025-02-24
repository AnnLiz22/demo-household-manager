package com.lietz.demo_household_manager.repository;

import com.lietz.demo_household_manager.model.Category;
import com.lietz.demo_household_manager.model.Task;
import com.lietz.demo_household_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignee(User assignee);
    List<Task> findByExecutor(User executor);
    List<Task> findByCategory(Category category);
    List<Task> findByCompletedTrue();
    List<Task> findByCompletedFalse();

}
