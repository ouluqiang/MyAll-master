package com.myolq.user.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.ErrorBean;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.frame.loader.callback.StringCallBack;

/**
 * Created by root on 2017-09-01.
 */

public class ForgetPasswrodContract {

    public interface View extends BaseView<ForgetPasswrodContract.Presenter> {
        void onSuccess(ErrorBean errorBean);
    }
    public interface Presenter extends BasePresenter {

        void getRequestPasswordReset(String email);
//        void getIssue(String session);
//        void getSelectUser(String username,String safetyIssue,String safetyAnswer);
    }
    public interface Model {

        void getRequestPasswordReset(String email,StringCallBack callBack);
        void getRequestPasswordReset(String email,GsonCallBack<ErrorBean> callBack);
//        void getIssue(String session,StringCallBack callBack);
//        void getSelectUser(String username,String safetyIssue,String safetyAnswer,StringCallBack callBack);
//        void getUser(GsonCallBack<UserBean> callBack);
    }

}
