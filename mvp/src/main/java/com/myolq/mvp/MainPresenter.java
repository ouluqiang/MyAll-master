package com.myolq.mvp;

import android.util.Log;

import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.mvp.bean.User;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/19.
 */

public class MainPresenter implements MainContract.Presenter{


    private final MainModel mainModel;
    MainContract.MainView mainView;

    public MainPresenter(MainContract.MainView mainView) {
        mainModel = new MainModel();
        this.mainView=mainView;
        mainView.setPresenter(this);
    }


    @Override
    public void start() {

    }


    @Override
    public void getUser(String user) {
        mainModel.getUser(user, new StringCallBack() {
            @Override
            public void onSuccess(String s) {
                Log.i("test",s);
                mainView.Toast(s);
            }

            @Override
            public void onError(com.lzy.okgo.model.Response response, Exception e) {

            }
        });
    }

    @Override
    public void getUser() {
        mainModel.getUser(new GsonCallBack<User>(User.class) {
            @Override
            public void onSuccess(User user) {
                Log.i("test",user.toString());
                mainView.Toast(user.toString());
            }

            @Override
            public void onError(com.lzy.okgo.model.Response response, Exception e) {

            }
        });
    }
}
