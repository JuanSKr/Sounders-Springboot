package com.sk.sounders.controller;

import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.impl.PostServiceImpl;
import com.sk.sounders.service.impl.UserServiceImpl;
import com.sk.sounders.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

    @Autowired
    StorageService storageService;


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

    @GetMapping("/profile/update/{username}")
    public String modifyProfile(@PathVariable String username, Model model) {
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
        model.addAttribute("user", user);
        model.addAttribute("userFromMail", userFromMail);
        if (user == null) {
            return "error";
        }
        model.addAttribute("formUser", user);
        return "form_profile";
    }


    @PostMapping("/profile/modify")
    public String modifyProfile(@ModelAttribute("formUser") User user,
                                @RequestParam("image") MultipartFile avatar) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);

        if (!avatar.isEmpty()) {
            String name = currentUser.getId() + "_avatar" + ".jpg";
            String filename = storageService.store(avatar, name);
            user.setAvatarPath("/files/" + filename);
        }

        if (user.getBio() == null) {
            currentUser.setBio("¡Soy nuevo en Sounders!");
        } else {
            currentUser.setBio(user.getBio());
        }

        currentUser.setName(user.getName());

        userService.save(currentUser);

        return "redirect:/profile/" + currentUser.getUsername();
    }


}
