package com.lietz.demo_household_manager.service;

import com.lietz.demo_household_manager.model.Comment;
import com.lietz.demo_household_manager.model.Task;
import com.lietz.demo_household_manager.model.User;
import com.lietz.demo_household_manager.repository.CommentRepository;
import com.lietz.demo_household_manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findByUser(User user) {
        return commentRepository.findByUser(user);
    }

    public List<Comment> findByTask(Task task) {
        return commentRepository.findByTask(task);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

}
