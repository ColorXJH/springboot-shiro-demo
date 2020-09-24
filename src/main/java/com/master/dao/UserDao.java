package com.master.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/24 12:31
 */
@Repository
//@MapperScan 也可以
public interface UserDao {
    /**
     * @description: 获得密码
     * @method: getPasswd
     * @param: [username]
     * @return: java.lang.String
     * @author: ColorXJH
     * @date: 2020/9/24 14:22
     */
    public String getPasswd(@Param("username") String username);
    /**
     * @description: 获得角色
     * @method: getRole
     * @param: [username]
     * @return: java.lang.String
     * @author: ColorXJH
     * @date: 2020/9/24 14:23
     */
    public List<String> getRoles(@Param("username")String username);
    /**
     * @description: 获得权限
     * @method: getPermissions
     * @param: [username]
     * @return: java.util.List<java.lang.String>
     * @author: ColorXJH
     * @date: 2020/9/24 14:42
     */
    public List<String>getPermissions(@Param("username")String username);
}
