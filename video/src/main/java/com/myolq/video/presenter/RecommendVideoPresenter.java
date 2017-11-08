package com.myolq.video.presenter;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Response;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.video.bean.VideoBean;
import com.myolq.video.contract.RecommendVideoContract;
import com.myolq.video.model.RecommendVideoModel;

/**
 * Created by root on 2017-08-24.
 */

public class RecommendVideoPresenter implements RecommendVideoContract.Presenter{

    private RecommendVideoModel model;
    private RecommendVideoContract.View view;

    public RecommendVideoPresenter(RecommendVideoContract.View view) {
        model = new RecommendVideoModel();
        this.view=view;
    }

    @Override
    public void start() {

    }

    @Override
    public void getRecommendVideo() {
        model.getRecommendVideo(new GsonCallBack<VideoBean>(new TypeToken<VideoBean>(){}.getType()) {
            @Override
            public void onSuccess(VideoBean videoBean) {
                if (videoBean.getDm_error()==0&&videoBean.getLives()!=null&&videoBean.getLives().size()>0){
                    view.onSuccess(videoBean.getLives());
                    view.state(1);
                }else{
                    view.onToast("暂无数据");
                    view.state(3);
                }
            }

            @Override
            public void onError(Response response) {
                view.state(2);
            }
        });
    }


}
