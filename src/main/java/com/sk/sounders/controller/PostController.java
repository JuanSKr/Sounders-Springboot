package com.sk.sounders.controller;

import com.sk.sounders.entity.User;
import com.sk.sounders.service.impl.PostServiceImpl;
import com.sk.sounders.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;


    @GetMapping("/post/{id}/{username}/{title}")
    public String viewPost(@PathVariable String title, @PathVariable long id, @PathVariable String username, Model model) {
        model.addAttribute("post", postService.findByTitleAndAuthorAndId(title, userService.findByUsername(username), id));
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        if (userDetails == null) {
            return "error";
        }
        String currentUsername = userDetails.getUsername();
        User user = userService.findByEmail(currentUsername);
        model.addAttribute("user", user);
        return "post";
    }

}
