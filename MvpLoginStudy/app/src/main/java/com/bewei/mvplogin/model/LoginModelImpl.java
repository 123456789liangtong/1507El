package com.bewei.mvplogin.model;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import com.bewei.mvplogin.LoginFinishListener;

/**
 * 1. 类的用途 登录的业务逻辑
 * 2. @author forever
 * 3. @date 2017/9/26 16:19
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final Context context, final String name, final String pwd, final LoginFinishListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    listener.onNameError();
                    listener.onPwdError();
                    Toast.makeText(context, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                    return;

                }
               /* boolean error = false;
                if (!error) {
                    listener.onNameError();
                    error = true;
                }
                if (!error) {
                    listener.onPwdError();
                    error = true;

                }*/

                listener.onSuccess();
                Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();


            }
        }, 2000);

    }
}
