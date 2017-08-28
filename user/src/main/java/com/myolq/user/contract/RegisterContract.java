package com.myolq.user.contract;

import com.myolq.frame.BasePresenter;
import com.myolq.frame.BaseView;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.user.User;
import com.myolq.user.bean.UserBean;

/**
 * Created by root on 2017-08-24.
 */

public class RegisterContract {

    public interface RegisterView extends BaseView<RegisterContract.Presenter> {
        void onToast(String s);
    }
    public interface Presenter extends BasePresenter {

        void getRegister(UserBean user);
//        void getUser();
    }
    public interface Model {

        void getRegister(UserBean user, StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }


}
