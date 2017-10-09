package com.bewei.mvplogin.presenter;

import android.content.Context;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/26 16:20
 */

public interface LoginPresenter {
    void validatePass(Context context,String name, String pwd);
}
