
package com.example.event_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.event_management.entity.User;
import com.example.event_management.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Open login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Open registration page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Register new user
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        }

        user.setRole("USER");

        userRepository.save(user);

        return "redirect:/";
    }

    // Login user and admin
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {

            session.setAttribute("user", user);

            if ("ADMIN".equals(user.getRole())) {
                return "redirect:/admin-dashboard";
            }

            return "redirect:/user-dashboard";
        }

        return "redirect:/?error";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }
}
