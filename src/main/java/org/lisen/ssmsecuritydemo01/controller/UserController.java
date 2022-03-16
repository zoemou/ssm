package org.lisen.ssmsecuritydemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:14
 * @Created by lisen
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
