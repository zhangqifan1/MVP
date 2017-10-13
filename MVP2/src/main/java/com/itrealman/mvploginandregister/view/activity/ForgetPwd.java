package com.itrealman.mvploginandregister.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itrealman.mvploginandregister.R;
import com.itrealman.mvploginandregister.bean.User;
import com.itrealman.mvploginandregister.presenter.Presenter;
import com.itrealman.mvploginandregister.view.viewinter.ViewInter;

public class ForgetPwd extends Activity implements View.OnClickListener,ViewInter {

    /**
     * 请输入要找回的用户名
     */
    private EditText mUserNameF;
    /**
     * 请输入新密码
     */
    private EditText mUserPwdF;
    /**
     * 确定修改
     */
    private Button mBtnLoginF;
    /**
     * 清除
     */
    private Button mBtnClearF;
    private ProgressBar mProgressBar;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        initView();
        presenter = new Presenter(this,ForgetPwd.this);
    }

    private void initView() {
        mUserNameF = (EditText) findViewById(R.id.user_name_F);
        mUserPwdF = (EditText) findViewById(R.id.user_pwd_F);
        mBtnLoginF = (Button) findViewById(R.id.btn_login_F);
        mBtnLoginF.setOnClickListener(this);
        mBtnClearF = (Button) findViewById(R.id.btn_clear_F);
        mBtnClearF.setOnClickListener(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_F:
                presenter.setNewPwd();
                break;
            case R.id.btn_clear_F:
                //告诉presenter层，我需要清除操作
                presenter.clear();
                break;
        }
    }

    @Override
    public String getName() {
        return mUserNameF.getText().toString();
    }

    @Override
    public String getPass() {
        return mUserPwdF.getText().toString();
    }

    @Override
    public void clearUserName() {
        mUserNameF.setText("");
    }

    @Override
    public void clearUserPass() {
        mUserPwdF.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void successHint(User user, String tag) {
        Toast.makeText(ForgetPwd.this,"成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failHint(User user, String tag) {
        Toast.makeText(ForgetPwd.this,"修改失败",Toast.LENGTH_SHORT).show();
    }
}
