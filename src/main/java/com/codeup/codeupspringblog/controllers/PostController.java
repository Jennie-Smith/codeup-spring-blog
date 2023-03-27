package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.repositories.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(path = "/posts")
public class PostController {
    private final PostRepository postDao;
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

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createGet() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        System.out.println(post);
        postDao.save(post);
        return "redirect:/posts";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
