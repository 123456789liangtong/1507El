package com.bewei.mvplogin.model;

import android.content.Context;

import com.bewei.mvplogin.LoginFinishListener;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/26 16:17
 */

public interface LoginModel {
    void login(Context context, String name, String pwd, LoginFinishListener listener);
}
