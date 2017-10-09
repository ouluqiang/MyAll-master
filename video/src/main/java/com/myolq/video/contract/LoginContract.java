package com.myolq.video.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.video.bean.VideoBean;

/**
 * Created by root on 2017-08-24.
 */

public class LoginContract {

    public interface View extends BaseView<Presenter> {
        void onSuccess(VideoBean videoBean);
    }
    public interface Presenter extends BasePresenter{

        void getLogin();
    }
    public interface Model {

        void getLogin(GsonCallBack<VideoBean> callBack);
    }

}
