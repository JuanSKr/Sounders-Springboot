package com.sk.sounders.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Si el usuario está autenticado, redirigir a /users
        if (auth != null && auth.isAuthenticated()) {
            return "index";
        } else {
            return "home";
        }

    }
}