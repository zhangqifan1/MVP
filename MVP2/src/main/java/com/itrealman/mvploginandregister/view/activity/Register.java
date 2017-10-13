package com.itrealman.mvploginandregister.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.itrealman.mvploginandregister.R;
import com.itrealman.mvploginandregister.bean.User;
import com.itrealman.mvploginandregister.presenter.Presenter;
import com.itrealman.mvploginandregister.view.viewinter.ViewInter;

/**
 * Created by Real_Man on 2016/8/20.
 */
public class Register extends AppCompatActivity implements ViewInter {

    private EditText mUserName;
    private EditText mUserPwd;
    private Button mBtnRegister;
    private Button mBtnClear;
    private ProgressBar mProBar;
    private TextView mTvLogin;//点击注册控件
    private Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        event();
        presenter = new Presenter(this, Register.this);
    }


    private void initView() {
        mUserName = (EditText) findViewById(R.id.user_name);
        mUserPwd = (EditText) findViewById(R.id.user_pwd);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mProBar = (ProgressBar) findViewById(R.id.progressBar);
        mTvLogin = (TextView) findViewById(R.id.mTvLogin);
    }

    private void event() {
        /**
         * 注册功能
         */
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
            }
        });
        /**
         * 清除功能
         */
        mBtnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
        /**
         * 启动登录界面
         */
        mTvLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public String getName() {
        return mUserName.getText().toString();
    }

    @Override
    public String getPass() {
        return mUserPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mUserName.setText("");
    }

    @Override
    public void clearUserPass() {
        mUserPwd.setText("");
    }

    @Override
    public void showLoading() {
        mProBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProBar.setVisibility(View.GONE);
    }

    @Override
    public void successHint(User user, String tag) {
        Toast.makeText(this, "用户" + user.getUserName() + tag + "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failHint(User user, String tag) {
        Toast.makeText(this, "用户" + user.getUserName() + tag + "失败,已存在该用户", Toast.LENGTH_SHORT).show();
    }


}
