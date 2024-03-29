package com.sk.sounders.controller;

import com.sk.sounders.entity.Message;
import com.sk.sounders.entity.Post;
import com.sk.sounders.entity.User;
import com.sk.sounders.service.MessageService;
import com.sk.sounders.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    MessageService messageService;

    @GetMapping("/chat")
    public String showUsers(Model model, Authentication authentication) {
        model.addAttribute("userList", userService.findAll());
        User actual = userService.findByEmail(authentication.getName());
        model.addAttribute("actual", actual);
        model.addAttribute("messageList", messageService.findByReceiver(actual));
        model.addAttribute("post", new Post());
        model.addAttribute("user", null);
        return "users_list";
    }

    @GetMapping("/chat/{username}")
    public String chat(@PathVariable String username, Model model, HttpSession request, Authentication authentication) {

        User actual = userService.findByEmail(authentication.getName());
        User receiver = userService.findByUsername(username);
        model.addAttribute("actual", actual);
        model.addAttribute("receiver", receiver);

        List<Message> list1 = messageService.findBySenderAndReceiver(actual, receiver);
        List<Message> list2 = messageService.findBySenderAndReceiver(receiver, actual);

        List<Message> mix = new ArrayList<>();
        mix.addAll(list1);
        mix.addAll(list2);
        Collections.sort(mix, new Comparator<Message>() {
            @Override
            public int compare(Message m1, Message m2) {
                return m1.getDate().compareTo(m2.getDate());
            }
        });
        model.addAttribute("messagesList", mix);

        Message message = new Message();
        message.setSender(actual);
        message.setReceiver(receiver);
        model.addAttribute("message", new Message());
        return "chat";
    }

    @GetMapping("/chat/search")
    public String searchUsers(@RequestParam String username, Model model, Authentication authentication) {
        User actual = userService.findByEmail(authentication.getName());
        model.addAttribute("actual", actual);
        User user = userService.findByUsername(username);
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("post", new Post());
        return "users_list";
    }

    @PostMapping("/send")
    public String saveMessage(@ModelAttribute("message") Message message,
                              HttpServletRequest request,
                              @RequestParam("receiver") Long receiverId,
                              @RequestParam("sender") Long senderId) {
        message.setDate(LocalDateTime.now());
        message.setSender(userService.findById(senderId));
        message.setReceiver(userService.findById(receiverId));
        messageService.save(message);

        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}