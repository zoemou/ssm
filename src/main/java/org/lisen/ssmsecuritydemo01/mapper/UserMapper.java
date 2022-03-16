package org.lisen.ssmsecuritydemo01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lisen.ssmsecuritydemo01.model.MyUser;

/**
 * @Version 1.0.0
 * @Date 2022-03-10 14:51
 * @Created by lisen
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public MyUser getUserByName(String userName);
}
