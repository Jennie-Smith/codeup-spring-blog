package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private final PostRepository postDao;
    @Autowired
    private final UserRepository userDao;

    @Autowired
    private final EmailService emailService;
    @GetMapping
    public String all(Model model){
        List<Post> posts = postDao.findAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewPosts(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        System.out.println(post);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    public String createGet(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
//        User user = userDao.findById(1L).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        System.out.println(post);
        postDao.save(post);
        emailService.prepareAndSend(post, "A post has been created: " + post.getTitle(), post.toString());
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String editGet(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/edit";
    }
    @PostMapping("/edit")
    public String editPost(@ModelAttribute Post post) {
//        User user = userDao.findById(1L).get();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        System.out.println(post);
        postDao.save(post);
        return "redirect:/posts";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
