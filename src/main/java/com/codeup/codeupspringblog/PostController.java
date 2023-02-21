package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "Here are all your blog posts!";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable long id){
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "Create post form";
    }

}
