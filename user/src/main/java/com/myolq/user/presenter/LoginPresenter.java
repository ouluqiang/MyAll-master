package com.myolq.user.presenter;

import android.util.Log;

import com.lzy.okgo.model.Response;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.user.bean.UserBean;
import com.myolq.user.contract.LoginContract;
import com.myolq.user.model.LoginModel;

/**
 * Created by root on 2017-08-24.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private final LoginModel loginModel;
    LoginContract.LoginView loginView;

    public LoginPresenter(LoginContract.LoginView loginView) {
        loginModel = new LoginModel();
        this.loginView=loginView;
        this.loginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getLogin(String username, String password) {
        loginModel.getLogin(username, password, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                Log.i("test",s);
                loginView.onToast(s);
            }

            @Override
            public void onError(Response response, Exception e) {

            }
        });
    }

//    @Override
//    public void getUser(String user) {
//        loginModel.getLogin(user, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                Log.i("test",s);
//                loginView.onToast(s);
//            }
//
//            @Override
//            public void onError(com.lzy.okgo.model.Response response, Exception e) {
//
//            }
//        });
//    }
//
//    @Override
//    public void getUser() {
//        loginModel.getUser(new GsonCallBack<UserBean>(UserBean.class) {
//            @Override
//            public void onSuccess(UserBean user) {
//                Log.i("test",user.toString());
//                loginView.onToast(user.toString());
//            }
//
//            @Override
//            public void onError(com.lzy.okgo.model.Response response, Exception e) {
//
//            }
//        });
//    }
}
