package org.lisen.ssmsecuritydemo01.service.impl;

import org.lisen.ssmsecuritydemo01.mapper.UserMapper;
import org.lisen.ssmsecuritydemo01.model.Role;
import org.lisen.ssmsecuritydemo01.model.MyUser;
import org.lisen.ssmsecuritydemo01.service.RoleService;
import org.lisen.ssmsecuritydemo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version 1.0.0
 * @Date 2022-03-16 10:29
 * @Created by lisen
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public MyUser getUserByName(String userName) {
        MyUser user = userMapper.getUserByName(userName);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MyUser user = getUserByName(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }

        //根据用户获取用户角色
        List<Role> roles = roleService.getUserRole(user.getUserId());
        //定义权限集合
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        //添加权限到集合中
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleType()));
        }
        boolean booleanStatus = true;
        if(user.getStatus() == 0){
            booleanStatus = false;
        }
        //加密密码
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        User userInfo = new User(user.getUserName(),bCryptPasswordEncoder.encode(user.getPassword()),booleanStatus,true,true, true, grantedAuthorities);
        return userInfo;
    }
}
