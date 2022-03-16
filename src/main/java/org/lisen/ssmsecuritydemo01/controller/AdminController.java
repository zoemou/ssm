package org.lisen.ssmsecuritydemo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Version 1.0.0
 * @Date 2022-03-11 10:21
 * @Created by lisen
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
