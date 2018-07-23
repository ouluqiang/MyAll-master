package com.myolq.user.presenter;

import android.util.Log;

import com.lzy.okgo.model.Response;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.loader.callback.StringCallBack;
import com.myolq.frame.utils.GsonUtils;
import com.myolq.user.contract.RegisterContract;
import com.myolq.user.model.RegisterModel;

/**
 * Created by root on 2017-08-24.
 */

public class RegisterPresenter implements RegisterContract.Presenter {


    private  RegisterModel model;
    private  RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        model = new RegisterModel();
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getRegister(final UserBean user) {
        view.onLoadShow();
        model.getRegister(user, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                Log.i("test","getRegister："+s);
                UserBean userBean= GsonUtils.getBeanFromJson(s,UserBean.class);
                if (userBean.getCode()==null){
                    view.onToast("注册成功");
                    getRequestEmailVerify(user.getEmail());
                    view.onFinish();

                }else{
                    view.onToast(userBean.getError());
                }
            }

            @Override
            public void onError(Response response) {
                view.onToast(response.body().toString());
                view.onLoadCancel();
//                Log.i("test","onError"+response.code()+"--"+response.message());
//                registerView.onToast(response.code()+(String)response.body());
            }
        });
    }

    @Override
    public void getRequestEmailVerify(String email) {
        view.onLoadShow();
        model.getRequestEmailVerify(email, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                Log.i("test","getRequestEmailVerify："+s);
//                view.onToast("注册成功");

            }

            @Override
            public void onError(Response response) {
                view.onLoadCancel();
//                Log.i("test","onError"+response.code()+"--"+response.message());
//                registerView.onToast(response.code()+(String)response.body());
            }
        });
    }
}
