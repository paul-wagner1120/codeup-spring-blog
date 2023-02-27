package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
//    @GetMapping("/posts")
//    public String posts(Model model){
//        Post post = new Post(1, "New Post", "Look at this new post");
//        Post post1 = new Post(2, "New Post 1", "Another new post");
//        ArrayList <Post> allPosts = new ArrayList<>();
//        allPosts.add(post);
//        allPosts.add(post1);
//        model.addAttribute("posts", allPosts);
//        return "/posts/index";
//    }

    @GetMapping("/posts")
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }


    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        Post post = new Post(id, "New Post", "Look at this new post");
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create(){

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

}
