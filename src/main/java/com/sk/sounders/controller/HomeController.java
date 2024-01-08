package com.sk.sounders.controller;

import com.sk.sounders.entity.PostLike;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.impl.LikeService;
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
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    LikeService likeService;

    @Autowired
    StorageService storageService;

    @GetMapping("/home")
    public String viewPosts(Model model) {
        model.addAttribute("post", new Post());

        try {
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
        } catch (NullPointerException | TemplateProcessingException e) {
            System.out.println("No hay posts");
        }

        try {
            model.addAttribute("posts", postService.findAllDesc());
        } catch (NullPointerException e) {
            System.out.println("No hay posts");
        }
        return "home";
    }


    @PostMapping("/post/save")
    public String savePost(@ModelAttribute("post") Post post, @RequestParam("image") MultipartFile file) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (user != null) {
            post.setAuthor(user);
            post.setDate(LocalDate.now());
            LocalTime hour = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            post.setHour(LocalTime.parse(hour.format(formatter)));
            if (!file.isEmpty()) {
                String name = post.getId() + "_" + post.getDate() + post.getHour() + ".jpg";
                String filename = storageService.store(file, name);
                post.setImagePath("/files/" + filename);
            }
            postService.save(post);
        } else {
            System.err.println("No se ha encontrado el usuario");
        }

        System.out.println("Post guardado");
        return "redirect:/home";
    }

    @DeleteMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") long id) {
        postService.deleteById(id);
        return "redirect:/home";
    }

    @GetMapping("/like/{id}")
    public String likePost(@PathVariable long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);

        Post post = postService.findById(id);
        PostLike like = likeService.findByPostAndUser(post, user);

        if (like == null) {
            like = new PostLike();
            like.setUser(user);
            like.setPost(post);
            like.setState(true);
        } else {
            like.setState(!like.isState());
        }
        likeService.save(like);
        return "redirect:/" + "#" + id;
    }
}