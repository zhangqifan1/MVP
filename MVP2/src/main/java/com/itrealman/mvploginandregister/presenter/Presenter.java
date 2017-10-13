package com.itrealman.mvploginandregister.presenter;

import android.content.Context;
import android.os.Handler;

import com.itrealman.mvploginandregister.bean.User;
import com.itrealman.mvploginandregister.model.modelimp.ModelImp;
import com.itrealman.mvploginandregister.model.modelinter.ModelInter;
import com.itrealman.mvploginandregister.model.modelinter.OnForgetListener;
import com.itrealman.mvploginandregister.model.modelinter.OnLoginListener;
import com.itrealman.mvploginandregister.model.modelinter.OnRegisterListener;
import com.itrealman.mvploginandregister.view.viewinter.ViewInter;

/**
 * Created by Real_Man on 2016/8/20.
 */
public class Presenter {
    //view层的控件，对view层进行操作
    ViewInter viewInter;
    //模型层的控件,对model层进行操作
    ModelInter modelInter;

    public Presenter(ViewInter viewInter, Context context) {
        this.viewInter = viewInter;
        modelInter = new ModelImp(context);
    }

    /**
     * 注册功能
     */
    public void register() {
        //显示进度条
        viewInter.showLoading();
         //控制层开始处理数据，拿到视图层的name,pass之后，进行注册操作
        //OnRegisterListener匿名内部类
        modelInter.register(viewInter.getName(), viewInter.getPass(), new OnRegisterListener() {
            /**
             * 如果注册成功模型层就会调用该方法
             * 其中的handler表示模拟延时3秒响应操作
             * @param user 返回已经注册的用户信息
             */
            @Override
            public void registerSuccess(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //隐藏进度条
                        viewInter.hideLoading();
                        //返回成功状态信息
                        viewInter.successHint(user,TAG);
                    }
                }, 3000);

            }
            /**
             * 如果注册失败模型层就会调用该方法
             * 其中的handler表示模拟延时3秒响应操作
             * @param user 返回未注册的用户信息
             */
            @Override
            public void registerFail(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //隐藏进度条
                        viewInter.hideLoading();
                        //返回失败状态信息
                        viewInter.failHint(user,TAG);
                    }
                }, 3000);

            }
        });
    }

    /**
     * 清除功能
     */
    public void clear() {
        viewInter.clearUserName();
        viewInter.clearUserPass();
    }

    /**
     * 登录功能，其基本实现和注册一样，只是模型层处理的逻辑不一样
     */
    public void login(){
        viewInter.showLoading();
        modelInter.login(viewInter.getName(), viewInter.getPass(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewInter.hideLoading();
                        viewInter.successHint(user,TAG);
                    }
                },3000);

            }

            @Override
            public void loginFail(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewInter.hideLoading();
                        viewInter.failHint(user,TAG);
                    }
                },3000);

            }
        });
    }
    /**
     * 忘记密码,修改功能
     * 检查是否有此用户
     */
    public void setNewPwd(){
        viewInter.showLoading();
        modelInter.forgetAndSetNewPwd(viewInter.getName(), viewInter.getPass(), new OnForgetListener() {
            @Override
            public void setSuccess(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //隐藏进度条
                        viewInter.hideLoading();
                        //返回成功状态信息
                        viewInter.successHint(user,TAG);
                    }
                }, 3000);
            }
            @Override
            public void setFail(final User user) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        viewInter.hideLoading();
                        viewInter.failHint(user,TAG);
                    }
                },3000);
            }
        });
    }
}
