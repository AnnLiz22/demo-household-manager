package com.lietz.demo_household_manager.controller;

import com.lietz.demo_household_manager.model.Category;
import com.lietz.demo_household_manager.model.Task;
import com.lietz.demo_household_manager.service.TaskService;
import com.lietz.demo_household_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks/list";
    }

    @GetMapping("/{id}")
    public String showTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "tasks/show";
    }

    @GetMapping("/create")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("categories", Category.values());
        return "tasks/form";
    }

    @PostMapping
    public String saveTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("categories", Category.values());
        return "tasks/form";
    }

    @GetMapping("/{id}/complete")
    public String completeTask(@PathVariable Long id) {
        taskService.completeTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
