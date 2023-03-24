package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts/{id}")
    public String id(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "posts/show";
    }

    @GetMapping("/posts")
    public String all(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("Valentine's Day", "Love is in the air!"));
        posts.add(new Post("Halloween", "Very spooky day"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String createGet() {
        return "view the form for creating a post";
    }

    @PostMapping(path = "/posts/create")
    public String createPost() {
        return "create a new post";
    }
}
