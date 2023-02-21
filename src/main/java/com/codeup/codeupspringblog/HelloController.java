package com.codeup.codeupspringblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return String.format("%d plus 1 is %d!", number, number + 1);
    }

    @GetMapping("/exponent/{num}/{power}")

    public String exponent(@PathVariable int num, @PathVariable int power, Model model){
        model.addAttribute("num", num);
        model.addAttribute("power", power);
        model.addAttribute("num2", (int) Math.pow(num, power));
        return "exponent";
    }

}

