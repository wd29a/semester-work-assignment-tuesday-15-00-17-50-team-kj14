package com.example.library.controllers;

import com.example.library.models.User;
import com.example.library.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model ){
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "User creation failed : User with this mail "+ user.getEmail() + " already exist.");
            return "registration";
        }
        return "redirect:/login";
    }

}