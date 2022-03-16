package org.lisen.ssmsecuritydemo01.service;

import org.lisen.ssmsecuritydemo01.model.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Version 1.0.0
 * @Date 2022-03-16 10:12
 * @Created by lisen
 */
public interface UserService extends UserDetailsService {
    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public MyUser getUserByName(String userName);
}
