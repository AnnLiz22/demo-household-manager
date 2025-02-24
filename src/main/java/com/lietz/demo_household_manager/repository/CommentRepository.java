package com.lietz.demo_household_manager.repository;

import com.lietz.demo_household_manager.model.Comment;
import com.lietz.demo_household_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);
}
