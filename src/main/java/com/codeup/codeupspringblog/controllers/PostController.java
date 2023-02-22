package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String posts(Model model){
        Post post = new Post(1, "New Post", "Look at this new post");
        Post post1 = new Post(2, "New Post 1", "Another new post");
        ArrayList <Post> allPosts = new ArrayList<>();
        allPosts.add(post);
        allPosts.add(post1);
        model.addAttribute("posts", allPosts);
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        Post post = new Post(id, "New Post", "Look at this new post");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Create post form";
    }

}
