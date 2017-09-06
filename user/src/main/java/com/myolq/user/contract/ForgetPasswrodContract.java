package com.myolq.user.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.callback.StringCallBack;

/**
 * Created by root on 2017-09-01.
 */

public class ForgetPasswrodContract {

    public interface View extends BaseView<ForgetPasswrodContract.Presenter> {
        void onSuccess(String s);
    }
    public interface Presenter extends BasePresenter {

        void getRequestPasswordReset(String email);
        void getIssue(String session);

//        void getUser();
    }
    public interface Model {

        void getRequestPasswordReset(String email,StringCallBack callBack);
        void getIssue(String session,StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }

}
