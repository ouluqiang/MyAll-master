package com.myolq.user.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Response;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.utils.GsonUtils;
import com.myolq.frame.utils.LogUtils;
import com.myolq.frame.widget.LoadDialog;
import com.myolq.user.contract.LoginContract;
import com.myolq.user.model.LoginModel;

/**
 * Created by root on 2017-08-24.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginModel model;
    private LoginContract.View view;

    public LoginPresenter( LoginContract.View view) {
        model = new LoginModel();
        this.view=view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getLogin(String username, String password) {
//        view.onLoadShow();
//        model.getLogin(username, password, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                Log.i("test",s);
//                view.onLoadCancel();
//                UserBean userBean= GsonUtils.getBeanFromJson(s,UserBean.class);
//                if (userBean.getCode()==null){
//                }else{
//                    view.onToast(userBean.getError());
//                }
//            }
//
//            @Override
//            public void onError(Response response) {
//                view.onLoadCancel();
//                view.onToast(response.body().toString());
//            }
//        });
    }

    @Override
    public void getLogin(UserBean userBean) {
        view.onLoadShow();
        model.getLogin(userBean, new GsonCallBack<UserBean>(new TypeToken<UserBean>(){}.getType()) {
            @Override
            public void onSuccess(UserBean userBean) {
                view.onLoadCancel();
//                if (userBean.getCode()==null){
                    view.onSuccess(userBean);
//                }else{
//                    view.onToast(userBean.getError());
//                }
            }

            @Override
            public void onError(Response response) {
                view.onLoadCancel();
                view.onToast(response.body().toString());
            }
        });
    }

}
