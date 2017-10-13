package com.itrealman.mvploginandregister.model.modelinter;

/**
 * Created by Real_Man on 2016/8/20.
 */

/**
 * 所有数据处理操作功能都定义在这个接口中，方便扩展
 */
public interface ModelInter {
    /**
     * 注册操作
     *
     * @param name     用户名
     * @param pass     用户密码
     * @param listener 回调事件，如果成功调用注册成功方法，失败调用注册失败方法
     */
    void register(String name, String pass, OnRegisterListener listener);

    /**
     * 登录操作
     *
     * @param name     用户名
     * @param pass     用户密码
     * @param listener 回调事件，如果成功调用登录成功方法，失败调用登录失败方法
     */
    void login(String name, String pass, OnLoginListener listener);
    /**
     * 忘记密码
     * 修改密码
     * 检查用户名是否存在   如果有把这对数据存进数据库
     * @param name     用户名
     * @param pass     用户密码
     */
    void forgetAndSetNewPwd(String name, String pass, OnForgetListener listener);
}
