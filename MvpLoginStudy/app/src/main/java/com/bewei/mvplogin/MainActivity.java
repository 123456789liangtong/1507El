package com.bewei.mvplogin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bewei.mvplogin.presenter.LoginPresenter;
import com.bewei.mvplogin.presenter.LoginPresenterImpl;
import com.bewei.mvplogin.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText et_name;
    private EditText et_pwd;
    private ProgressBar pb;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        Button bt_login = (Button) findViewById(R.id.bt_login);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        pb = (ProgressBar) findViewById(R.id.pb);
        bt_login.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);

    }

    @Override
    public void onClick(View view) {
        presenter.validatePass(this, et_name.getText().toString(), et_pwd.getText().toString());
    }

    @Override
    public void showProgressBar() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pb.setVisibility(View.INVISIBLE);

    }

    @Override
    public void setNameError() {
        et_name.setError("name cannot be empty");
    }

    @Override
    public void setPwdError() {
        et_pwd.setError("pwd cannot be empty");

    }

    @Override
    public void toHomeActivity() {
        Toast.makeText(MainActivity.this, "登录成功跳转到首页", Toast.LENGTH_SHORT).show();
    }
}
