package com.lietz.demo_household_manager.controller;

import com.lietz.demo_household_manager.service.TaskService;
import com.lietz.demo_household_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
