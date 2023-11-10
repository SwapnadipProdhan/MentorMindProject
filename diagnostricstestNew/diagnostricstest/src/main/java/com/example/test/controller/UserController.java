package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String home() {
        return "index"; // Renders the home.html template
    }

    @GetMapping("/service")
    public String about() {
        return "service"; // Renders the about.html template
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        System.out.println(user);
        repo.save(user);
        redirectAttributes.addFlashAttribute("message", "Order Successfully");
        return "redirect:/";
    }
}

