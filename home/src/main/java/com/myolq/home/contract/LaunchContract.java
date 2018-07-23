package com.myolq.home.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.loader.callback.GsonCallBack;

/**
 * Created by root on 2017-09-04.
 */

public class LaunchContract {

    public interface View extends BaseView<LaunchContract.Presenter> {
        void onSuccess(UserBean userBean);
    }
    public interface Presenter extends BasePresenter {

        void getMe(String session);

    }
    public interface Model {

        void getMe(String session,GsonCallBack<UserBean> callBack);
    }
}
