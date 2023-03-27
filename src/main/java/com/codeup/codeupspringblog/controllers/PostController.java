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
        posts.add(new Post(1,"Valentine's Day", "Love is in the air!"));
        posts.add(new Post(2,"Halloween", "Very spooky day"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewPosts(@PathVariable long id) {
        Post post = postDao.findById(id).get();
        String newPost = post.getTitle() + post.getBody();
        post.setTitle(newPost);
        postDao.save(post);
        System.out.println(post);
        return "posts/show";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createGet() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String createPost(@PathVariable String title, @PathVariable String body) {
        Post post = new Post();
        post.setTitle(title);
        post.setTitle(body);
        postDao.save(post);
        return "posts/index";
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
