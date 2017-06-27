package com.myolq.mvp;

import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.mvp.bean.User;

/**
 * Created by Administrator on 2017/6/19.
 */

public interface MainContract {

    public interface MainView extends BaseView<Presenter>{
        void Toast(String s);
        void ToastError(String s);
    }
    public interface Presenter extends BasePresenter{

        void getUser(String user);
        void getUser();
    }
    public interface MainModel {

        void getUser(String user, StringCallBack callBack);
        void getUser(GsonCallBack<User> callBack);
    }





}
