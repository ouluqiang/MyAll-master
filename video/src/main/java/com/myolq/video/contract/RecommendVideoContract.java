package com.myolq.video.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.video.bean.VideoBean;

import java.util.List;

/**
 * Created by root on 2017-08-24.
 */

public class RecommendVideoContract {

    public interface View extends BaseView<Presenter> {
        void onSuccess(List<VideoBean.LivesBean> livesBean);
    }
    public interface Presenter extends BasePresenter{

        void getRecommendVideo();
    }
    public interface Model {

        void getRecommendVideo(GsonCallBack<VideoBean> callBack);
    }

}