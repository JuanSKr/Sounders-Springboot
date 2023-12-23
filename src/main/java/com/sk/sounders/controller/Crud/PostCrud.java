package com.sk.sounders.controller.Crud;

import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.impl.PostServiceImpl;
import com.sk.sounders.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostCrud {
    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/home")
    public String viewPosts(Model model) {
        model.addAttribute("post", new Post());
        try {
            model.addAttribute("posts", postService.findAllDesc());
        } catch (NullPointerException e) {
            System.out.println("No hay posts");
        }
        return "home";
    }

    @PostMapping("/post/save")
    public String savePost(@ModelAttribute("post") Post post) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String email = userDetails.getUsername();
        User user = userService.findByEmail(email);
        if (user != null) {
            post.setAuthor(user);
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
}