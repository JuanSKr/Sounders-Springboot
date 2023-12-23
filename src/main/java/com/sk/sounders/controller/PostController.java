package com.sk.sounders.controller;

import com.sk.sounders.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @GetMapping("/post/view/{title}")
    public String viewPost(@PathVariable String title, Model model) {
        model.addAttribute("post", postService.findByTitle(title));
        return "post";
    }

}
