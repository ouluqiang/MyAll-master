package com.myolq.user.contract;

import com.myolq.frame.BasePresenter;
import com.myolq.frame.BaseView;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.user.User;
import com.myolq.user.bean.UserBean;

/**
 * Created by root on 2017-08-24.
 */

public class LoginContract {

    public interface LoginView extends BaseView<Presenter> {
        void onToast(String s);
    }
    public interface Presenter extends BasePresenter{

        void getLogin(String username,String password);
//        void getUser();
    }
    public interface Model {

        void getLogin(String username,String password, StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }

}
