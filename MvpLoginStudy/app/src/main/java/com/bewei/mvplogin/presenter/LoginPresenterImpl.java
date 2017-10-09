package com.bewei.mvplogin.presenter;

import android.content.Context;

import com.bewei.mvplogin.LoginFinishListener;
import com.bewei.mvplogin.model.LoginModel;
import com.bewei.mvplogin.model.LoginModelImpl;
import com.bewei.mvplogin.view.LoginView;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/26 16:22
 */

public class LoginPresenterImpl implements LoginPresenter, LoginFinishListener {
    LoginView loginView;
    LoginModel loginModel;

    //构造传参进行初始化
    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        //多态
        loginModel = new LoginModelImpl();
    }

    @Override
    public void validatePass(Context context, String name, String pwd) {
        //p关联m进行数据逻辑
        loginModel.login(context, name, pwd, this);
    }

    @Override
    public void onNameError() {
        if (loginView != null) {
            loginView.setNameError();
        }
    }

    @Override
    public void onPwdError() {
        if (loginView != null) {
            loginView.setPwdError();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.toHomeActivity();
        }
    }
}
