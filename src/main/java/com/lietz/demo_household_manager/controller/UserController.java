package com.lietz.demo_household_manager.controller;

import com.lietz.demo_household_manager.model.User;
import com.lietz.demo_household_manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/show";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "users/form";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    return "users/form";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.delete(id);
        return "redirect:/users";
    }
}
