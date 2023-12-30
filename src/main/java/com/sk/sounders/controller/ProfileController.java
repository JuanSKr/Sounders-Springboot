package com.sk.sounders.controller;

import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.impl.PostServiceImpl;
import com.sk.sounders.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;


    @GetMapping("/profile/{username}")
    public String checkProfile(@PathVariable String username, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        if (userDetails == null) {
            return "error";
        }
        String currentUsername = userDetails.getUsername();
        User user = userService.findByUsername(username);
        User userFromMail = userService.findByEmail(currentUsername);
        if (user == null) {
            return "error";
        }
        model.addAttribute("user", user);
        model.addAttribute("userFromMail", userFromMail);
        model.addAttribute("posts", postService.findByAuthorOrderByIdDesc(user));
        if (username.equals(userFromMail.getUsername())) {
            return "myprofile";
        } else {
            return "profile";
        }
    }


}
