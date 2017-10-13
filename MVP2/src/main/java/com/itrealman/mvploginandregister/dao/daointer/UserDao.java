package com.itrealman.mvploginandregister.dao.daointer;


import com.itrealman.mvploginandregister.bean.User;

/**
 * Created by Real_Man on 2016/8/6.
 */
public interface UserDao {

    void addUser(User user);//添加新用户

    void delteUserByName(String name);//删除用户

    void updateUserPwd(String name, String pass);//通过同户名修改密码

    User queryUserByName(String name);//通过用户名查找用户

    boolean isExistsUser(User user);//判断是否存在重复用户

    boolean isExist(String name);//判断是否存在用户

    boolean isLoginSuccess(User user);
}
