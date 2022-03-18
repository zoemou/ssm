package org.lisen.ssmsecuritydemo01.controller;

import org.lisen.ssmsecuritydemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Version 1.0.0
 * @Date 2022-03-11 16:01
 * @Created by lisen
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login_page")
    @ResponseBody
    public String loginPage() {
        return "请登录";
    }
    /**
     * 用户注册`
     *
     * @param userName 用户名
     * @param password  用户密码
     * @return 返回登录页面
     */
    @PostMapping("/register")
    @ResponseBody
    public String userRegister(@RequestParam("username") String userName,
                               @RequestParam("password") String password) {
        if (userService.getUserByName(userName) == null) {
            userService.saveUser(userName,password);
        } else {
            return "该用户已存在";
        }
        return "用户["+userName+"]创建成功。";
    }
}
