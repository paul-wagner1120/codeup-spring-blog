package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.dao.PostRepository;
import com.codeup.codeupspringblog.dao.UserRepository;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final UserRepository userDao;
    private final PostRepository postDao;

    public PostController(UserRepository userDao, PostRepository postDao){
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsHome(Model model){
//        List<Post> posts = postDao.findAll();
//        model.addAttribute("posts", posts);
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/search")
    public String showAllPosts(@RequestParam String query, Model model){
        model.addAttribute("posts", postDao.searchByTitleLike(query));
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postsHome(@PathVariable long id, Model model){
//        System.out.println(postDao.findPostById(id));
        model.addAttribute("post", postDao.findPostById(id));
        model.addAttribute("userIsCreator", true);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsForm(Model model){
        // needs to match the th:field of the form
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String savePost(@ModelAttribute Post post) {
        User user = userDao.findUserById(1);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        model.addAttribute("post", postDao.findPostById(id));
        return "posts/create";
    }

}
