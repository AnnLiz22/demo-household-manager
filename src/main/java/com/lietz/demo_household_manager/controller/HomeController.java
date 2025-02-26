package com.lietz.demo_household_manager.controller;

import com.lietz.demo_household_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TaskService taskService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("uncompletedTasks", taskService.getUncompletedTasks());
        return "home";
    }
}
