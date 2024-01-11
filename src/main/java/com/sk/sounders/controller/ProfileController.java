package com.sk.sounders.controller;

import com.sk.sounders.entity.Comment;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.CommentService;
import com.sk.sounders.service.LikeService;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

    @Autowired
    StorageService storageService;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;


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
        model.addAttribute("currentUser", userFromMail);
        model.addAttribute("userFromMail", userFromMail);

        List<Post> postList = postService.findByAuthorOrderByIdDesc(user);

        for (Post post : postList) {
            post.setLikeState(likeService.activePostAndUser(post, userFromMail));
        }

        model.addAttribute("postList", postList);
        model.addAttribute("post", new Post());

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
    public String modifyProfile(@ModelAttribute("formUser") User user) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User currentUser = userService.findByEmail(email);

        if (user.getBio() == null) {
            currentUser.setBio("¡Soy nuevo en Sounders!");
        } else {
            currentUser.setBio(user.getBio());
        }

        currentUser.setName(user.getName());

        userService.save(currentUser);

        return "redirect:/profile/" + currentUser.getUsername();
    }

    @PostMapping("/profile/avatar")
    public String updateAvatar(@RequestParam("avatar") MultipartFile file) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (user != null) {
            if (!file.isEmpty()) {
                String name = user.getId() + "_avatar.jpg";
                String filename = storageService.store(file, name);
                user.setAvatar("/files/" + filename);
                userService.save(user);
            }
        } else {
            System.err.println("Error al actualizar el avatar");
        }

        return "redirect:/profile/" + user.getUsername();
    }

    @PostMapping("/profile/banner")
    public String updateBanner(@RequestParam("banner") MultipartFile file) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (user != null) {
            if (!file.isEmpty()) {
                String name = user.getId() + "_banner.jpg";
                String filename = storageService.store(file, name);
                user.setBanner("/files/" + filename);
                userService.save(user);
            }
        } else {
            System.err.println("No se ha encontrado el usuario");
        }

        return "redirect:/profile";
    }

}
