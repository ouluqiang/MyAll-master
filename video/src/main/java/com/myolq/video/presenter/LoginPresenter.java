package com.myolq.video.presenter;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Response;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.video.Video;
import com.myolq.video.bean.VideoBean;
import com.myolq.video.contract.LoginContract;
import com.myolq.video.model.LoginModel;

/**
 * Created by root on 2017-08-24.
 */

public class LoginPresenter implements LoginContract.Presenter{

    private LoginModel model;
    private LoginContract.View view;

    public LoginPresenter( LoginContract.View view) {
        model = new LoginModel();
        this.view=view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getLogin() {
        model.getLogin(new GsonCallBack<VideoBean>(new TypeToken<VideoBean>(){}.getType()) {
            @Override
            public void onSuccess(VideoBean videoBean) {
                if (videoBean.getDm_error()==0){
                    view.onSuccess(videoBean);
                }
            }

            @Override
            public void onError(Response response) {

            }
        });
//        view.onLoadShow();
//        model.getLogin(username, password, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                Log.i("test",s);
//                view.onLoadCancel();
//                UserBean userBean= GsonUtils.getBeanFromJson(s,UserBean.class);
//                if (userBean.getCode()==null){
//                }else{
//                    view.onToast(userBean.getError());
//                }
//            }
//
//            @Override
//            public void onError(Response response) {
//                view.onLoadCancel();
//                view.onToast(response.body().toString());
//            }
//        });
    }


}
