package org.lisen.ssmsecuritydemo01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lisen.ssmsecuritydemo01.model.Role;

import java.util.List;

/**
 * @Version 1.0.0
 * @Date 2022-03-16 10:18
 * @Created by lisen
 */
@Mapper
public interface RoleMapper {

    /**
     * 根据用户ID获取用户角色
     * @param userId
     * @return
     */
     List<Role> getUserRole(Integer userId);

     void saveRole(Role role);
}