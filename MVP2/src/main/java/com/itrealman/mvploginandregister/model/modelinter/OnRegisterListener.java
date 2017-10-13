package com.itrealman.mvploginandregister.model.modelinter;

import com.itrealman.mvploginandregister.bean.User;

/**
 * Created by Real_Man on 2016/8/20.
 */
/**
 * 注册成功或失败的接口
 */
public interface OnRegisterListener {
    //表示注册标签
    String TAG = "注册";
    /**
     * 注册成功，传递了用户信息
     *
     * @param user
     */
    void registerSuccess(User user);

    /**
     * 注册失败，传递了用户信息
     *
     * @param user
     */
    void registerFail(User user);

}
