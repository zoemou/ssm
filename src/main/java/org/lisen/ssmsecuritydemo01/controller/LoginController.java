package org.lisen.ssmsecuritydemo01.controller;


import org.lisen.ssmsecuritydemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @Version 1.0.0
 * @Date 2022-03-11 16:01
 * @Created by lisen
 */
@Controller
public class LoginController {

    private UserService userService;


//    @RequestMapping("/login_page")
//    public String loginPage() {
//        return "login_page";
//    }
    /**
     * 用户注册`
     *
     * @param userName 用户名
     * @param password  用户密码
     * @return 返回登录页面
     */
//    @PostMapping("/register")
//    @ResponseBody
//    public String userRegister(@RequestParam("username") String userName,
//                               @RequestParam("password") String password) {
//        if (userService.findUserByUserName(userName) == null) {
//            userService.saveUser(new User(userName, password));
//            return "userName:" + userName + "\n"+"password:" + password;
//        } else {
//            return "该用户已存在";
//        }
//    }
}
