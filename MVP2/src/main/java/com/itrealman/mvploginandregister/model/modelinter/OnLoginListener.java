package com.itrealman.mvploginandregister.model.modelinter;

import com.itrealman.mvploginandregister.bean.User;

/**
 * Created by Real_Man on 2016/8/20.
 */

/**
 * 登录成功或失败的接口
 */
public interface OnLoginListener {
    //表示登录状态
    String TAG = "登录";

    /**
     * 登录成功，传递了用户信息
     *
     * @param user
     */
    void loginSuccess(User user);

    /**
     * 登录失败，传递了用户信息
     *
     * @param user
     */
    void loginFail(User user);
}
