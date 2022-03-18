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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MyUser getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }


    public void saveUser(String userName,String password) {
        MyUser myUser = new MyUser();
        myUser.setUserName(userName);
        myUser.setPassword(passwordEncoder.encode(password));
        myUser.setPhone("12345678910");
        myUser.setEmail("json@shabi.org");
        myUser.setStatus(1);
        Date date = new Date();
        Timestamp timeStamp = new Timestamp(date.getTime()); // 将日期时间转换为数据库中的timestamp类型
        myUser.setCreationDate(timeStamp);
        myUser.setCreatedBy(1);
        myUser.setLastUpdateDate(timeStamp);
        myUser.setLastUpdatedBy(1);
        userMapper.saveUser(myUser);
        Role role = new Role();
        role.setUserId(getUserByName(userName).getUserId());
        role.setRoleId(2);
        roleService.saveRole(role);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MyUser myUser = getUserByName(userName);
        if (myUser == null) {
            throw new UsernameNotFoundException("用户名或密码输入错误，请重新输入!");
        }

        //根据用户获取用户角色
        List<Role> roles = roleService.getUserRole(myUser.getUserId());
        //定义权限集合
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<SimpleGrantedAuthority>();
        //添加权限到集合中
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleType()));
        }
        boolean booleanStatus = myUser.getStatus() != 0;
        //加密密码
        return new User(myUser.getUserName(),myUser.getPassword(),booleanStatus,true,true, true, grantedAuthorities);
    }
}
