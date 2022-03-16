package org.lisen.ssmsecuritydemo01.service.impl;

import org.lisen.ssmsecuritydemo01.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0.0
 * @Date 2022-03-10 15:08
 * @Created by lisen
 */
@Service("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //通过用户名从数据库获取用户
//        MyUser user = userService.findUserByUserName(username);
//        if (user == null) throw new UsernameNotFoundException("用户不存在");
//
//        return user;
//    }
}
