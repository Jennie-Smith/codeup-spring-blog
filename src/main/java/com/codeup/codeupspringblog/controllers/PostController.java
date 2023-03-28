package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private final PostRepository postDao;
    @Autowired
    private final UserRepository userDao;
    @GetMapping
    public String all(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";

    }

    @GetMapping("/{id}")
    public String viewPosts(@PathVariable long id, Model model) {
        Post post = postDao.findById(id).get();
        System.out.println(post);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    public String createGet() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.findById(1L).get();
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
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
