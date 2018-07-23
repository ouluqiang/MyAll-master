package com.myolq.user.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.frame.loader.callback.StringCallBack;

/**
 * Created by root on 2017-08-24.
 */

public class LoginContract {

    public interface View extends BaseView<Presenter> {
        void onSuccess(UserBean userBean);
    }
    public interface Presenter extends BasePresenter{

        void getLogin(String username, String password);
        void getLogin(UserBean userBean);
    }
    public interface Model {

        void getLogin(String username,String password, StringCallBack callBack);
        void getLogin(UserBean userBean,GsonCallBack<UserBean> callBack);
    }

}
