package com.myolq.user.presenter;

import android.content.Context;
import android.util.Log;

import com.lzy.okgo.model.Response;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.utils.LogUtils;
import com.myolq.frame.widget.LoadDialog;
import com.myolq.user.contract.LoginContract;
import com.myolq.user.model.LoginModel;

/**
 * Created by root on 2017-08-24.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginModel loginModel;
    private LoginContract.LoginView loginView;

    public LoginPresenter( LoginContract.LoginView loginView) {
        loginModel = new LoginModel();
        this.loginView=loginView;
        this.loginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getLogin(String username, String password) {
        loginView.onLoadShow();
        loginModel.getLogin(username, password, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                Log.i("test",s);
                loginView.onLoginSuccess(s);
            }

            @Override
            public void onError(Response response, Exception e) {
                loginView.onLoadCancel();
            }
        });
    }

}
