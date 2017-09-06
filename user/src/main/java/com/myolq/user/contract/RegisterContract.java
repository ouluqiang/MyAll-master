package com.myolq.user.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.StringCallBack;

/**
 * Created by root on 2017-08-24.
 */

public class RegisterContract {

    public interface View extends BaseView<RegisterContract.Presenter> {
//        void onToast(String s);
        void onFinish();
//        void onLoadShow();
//        void onLoadCancel();
    }
    public interface Presenter extends BasePresenter {

        void getRegister(UserBean user);
        void getRequestEmailVerify(String email);
//        void getUser();
    }
    public interface Model {

        void getRegister(UserBean user, StringCallBack callBack);
        void getRequestEmailVerify(String email,StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }


}
