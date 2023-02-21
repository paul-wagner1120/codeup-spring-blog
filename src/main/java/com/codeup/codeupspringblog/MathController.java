package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num, @PathVariable int num2){
        return String.format("%d plus %d = %d", num, num2, num + num2);
    }

    @GetMapping("/subtract/{num}/and/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num, @PathVariable int num2){
        return String.format("%d minus %d = %d", num, num2, num - num2);
    }

    @GetMapping("/multiply/{num}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num, @PathVariable int num2){
        return String.format("%d times %d = %d", num, num2, num * num2);
    }

    @GetMapping("/divide/{num}/and/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num, @PathVariable int num2){
        return String.format("%d divided by %d = %d", num, num2, num / num2);
    }
}
