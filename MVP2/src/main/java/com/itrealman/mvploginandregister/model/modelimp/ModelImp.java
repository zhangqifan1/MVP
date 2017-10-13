package com.itrealman.mvploginandregister.model.modelimp;

import android.content.Context;

import com.itrealman.mvploginandregister.bean.User;
import com.itrealman.mvploginandregister.dao.daoimp.ImpUserDao;
import com.itrealman.mvploginandregister.dao.daointer.UserDao;
import com.itrealman.mvploginandregister.model.modelinter.ModelInter;
import com.itrealman.mvploginandregister.model.modelinter.OnForgetListener;
import com.itrealman.mvploginandregister.model.modelinter.OnLoginListener;
import com.itrealman.mvploginandregister.model.modelinter.OnRegisterListener;

/**
 * Created by Real_Man on 2016/8/20.
 */

/**
 * 整体的逻辑实现，判断是否登录成功，失败
 */
public class ModelImp implements ModelInter {

    //获取数据库管理类，对数据库进行操作
    private UserDao userDao;

    public ModelImp(Context context){
        userDao = new ImpUserDao(context);
    }

    /**
     * 注册逻辑实现
     * @param name     用户名
     * @param pass     用户密码
     * @param listener 回调事件，如果成功调用注册成功方法，失败调用注册失败方法
     */
    @Override
    public void register(String name, String pass, OnRegisterListener listener) {
        //将用户名和密码封装到user中
        User user = new User(name,pass);
        //数据库不存在该用户注册成功，否则注册失败

        if(userDao.isExistsUser(user)){
            listener.registerFail(user);
        }else{
            userDao.addUser(user);
            listener.registerSuccess(user);
        }
    }

    /**
     * 登录逻辑实现
     * @param name     用户名
     * @param pass     用户密码
     * @param listener 回调事件，如果成功调用登录成功方法，失败调用登录失败方法
     */
    @Override
    public void login(String name, String pass, OnLoginListener listener) {
        User user = new User(name,pass);
        //判断是否登录成功
        if(userDao.isLoginSuccess(user)){
            listener.loginSuccess(user);
        }else{
            listener.loginFail(user);
        }
    }

    @Override
    public void forgetAndSetNewPwd(String name, String pass, OnForgetListener listener) {
        User user = new User(name,pass);

        if(!userDao.isExist(name)){
            listener.setFail(user);
        }else{
            userDao.addUser(user);
            listener.setSuccess(user);
        }

    }


}
