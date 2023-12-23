package com.sk.sounders.controller;

import com.sk.sounders.dto.UserDto;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        User existingUsername = userService.findByUsername(user.getUsername());
        if (existing != null) {
            result.rejectValue("email", null, "Esta cuenta ya está registrada.");
        }
        if (existingUsername != null) {
            result.rejectValue("username", null, "Este nombre de usuario ya está registrado.");
        }

        if(!Objects.equals(user.getPassword(), user.getConfirmPassword())){
            result.rejectValue("confirmPassword", null, "Las contraseñas no coinciden.");
        }



        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

}
