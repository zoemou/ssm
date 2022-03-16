package org.lisen.ssmsecuritydemo01.service.impl;

import org.lisen.ssmsecuritydemo01.mapper.RoleMapper;
import org.lisen.ssmsecuritydemo01.model.Role;
import org.lisen.ssmsecuritydemo01.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version 1.0.0
 * @Date 2022-03-16 10:46
 * @Created by lisen
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getUserRole(Integer userId) {
        List<Role> roles = roleMapper.getUserRole(userId);
        return roles;
    }
}
