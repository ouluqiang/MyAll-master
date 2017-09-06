package com.myolq.home.presenter;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Response;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.callback.GsonCallBack;
import com.myolq.frame.callback.StringCallBack;
import com.myolq.frame.config.UserConfig;
import com.myolq.frame.utils.LogUtils;
import com.myolq.home.contract.LaunchContract;
import com.myolq.home.model.LaunchModel;

/**
 * Created by root on 2017-09-04.
 */

public class LaunchPresenter implements LaunchContract.Presenter {

    private LaunchModel model;
    private LaunchContract.View view;

    public LaunchPresenter(LaunchContract.View view) {
        this.model = new LaunchModel();
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getMe(String session) {
        view.onLoadShow();
        model.getMe(session, new GsonCallBack<UserBean>(new TypeToken<UserBean>() {}.getType()) {
            @Override
            public void onSuccess(UserBean userBean) {
                view.onLoadCancel();
//                if (userBean!=null&&userBean.getCode()==null){
                    view.onSuccess(userBean);
//                }else{
//                    view.onToast(userBean.getError());
//                }
            }

            @Override
            public void onError(Response response) {
                view.onLoadCancel();
            }
        });

    }
}
