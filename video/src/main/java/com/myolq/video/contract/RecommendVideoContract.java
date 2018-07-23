package com.myolq.video.contract;

import com.myolq.frame.base.BasePresenter;
import com.myolq.frame.base.BaseView;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.video.bean.VideoBean;

import java.util.List;

/**
 * Created by root on 2017-08-24.
 */

public class RecommendVideoContract {

    public interface View extends BaseView<Presenter> {
        void onSuccess(List<VideoBean.LivesBean> livesBean);
        void state(int type);
        void cancel();

    }
    public interface Presenter extends BasePresenter{

        void getRecommendVideo();
    }
    public interface Model {

        void getRecommendVideo(GsonCallBack<VideoBean> callBack);
    }

}
