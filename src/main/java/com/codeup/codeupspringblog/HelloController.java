package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number){
        return String.format("%d plus 1 is %d!", number, number + 1);
    }

    @GetMapping("/exponent/{num}/{power}")
    @ResponseBody
    public String exponent(@PathVariable int num, @PathVariable int power){
        return String.format("%d to the %d is %d", num, power, (int) (Math.pow(num,power)));
    }

}

