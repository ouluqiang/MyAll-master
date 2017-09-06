package com.myolq.user.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.callback.StringCallBack;

/**
 * Created by root on 2017-08-24.
 */

public class LoginContract {

    public interface View extends BaseView<Presenter> {
//        void onToast(String s);
//        void onLoadShow();
//        void onLoadCancel();
        void onSuccess(String s);
    }
    public interface Presenter extends BasePresenter{

        void getLogin(String username, String password);
//        void getUser();
    }
    public interface Model {

        void getLogin(String username,String password, StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }

}
