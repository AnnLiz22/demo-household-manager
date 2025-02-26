package com.lietz.demo_household_manager.controller;

import com.lietz.demo_household_manager.model.Comment;
import com.lietz.demo_household_manager.service.CommentService;
import com.lietz.demo_household_manager.service.TaskService;
import com.lietz.demo_household_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final TaskService taskService;
    private final UserService userService;

    @PostMapping
    public String saveComment(@ModelAttribute Comment comment, @RequestParam Long taskId, @RequestParam Long userId) {
    comment.setTask(taskService.getTaskById(taskId));
    comment.setUser(userService.getUserById(userId));
    commentService.saveComment(comment);
    return "redirect:/tasks/" + taskId;
    }

    @GetMapping("/{id}/delete")
    public String deleteComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        Long taskId = comment.getTask().getId();
        commentService.deleteComment(taskId);
        return "redirect:/tasks/" + taskId;
    }
}
