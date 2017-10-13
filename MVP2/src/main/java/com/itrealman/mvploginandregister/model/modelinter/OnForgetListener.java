package com.itrealman.mvploginandregister.model.modelinter;

import com.itrealman.mvploginandregister.bean.User;

/**
 * Created by Real_Man on 2016/8/20.
 */

public interface OnForgetListener {
    //表示注册标签
    String TAG = "忘记密码";

    void setSuccess(User user);


    void setFail(User user);

}
