package com.sk.sounders.controller;

import com.sk.sounders.entity.Comment;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.CommentService;
import com.sk.sounders.service.LikeService;
import com.sk.sounders.service.impl.PostServiceImpl;
import com.sk.sounders.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CommentService commentService;

    @Autowired
    LikeService likeService;


    @GetMapping("/post/{username}/{id}")
    public String viewPost(@PathVariable String username, @PathVariable long id, Model model) {
        Post post = postService.findByAuthorAndId(userService.findByUsername(username), id);

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

        post.setLikeState(likeService.activePostAndUser(post, user));

        model.addAttribute("post", post);
        model.addAttribute("user", user);
        model.addAttribute("comments", commentService.findByPost(post));
        model.addAttribute("newComment", new Comment());
        model.addAttribute("newPost", new Post());
        return "post";
    }

    @PostMapping("/comment/add")
    public String saveComment(@ModelAttribute("newComment") Comment comment, @RequestParam long idPost, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        if (userDetails == null) {
            return "error";
        }
        String currentUsername = userDetails.getUsername();
        User commentAuthor = userService.findByEmail(currentUsername);
        model.addAttribute("commentAuthor", commentAuthor);

        Post post = postService.findById(idPost);
        User postAuthor = post.getAuthor();

        comment.setAuthor(commentAuthor);
        comment.setPost(post);
        comment.setDate(LocalDate.now());
        LocalTime hour = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        comment.setHour(LocalTime.parse(hour.format(formatter)));
        commentService.save(comment);

        return "redirect:/post/" + postAuthor.getUsername() + "/" + post.getId();

    }

}
