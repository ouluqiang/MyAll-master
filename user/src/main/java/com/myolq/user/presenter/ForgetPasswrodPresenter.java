package com.myolq.user.presenter;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.model.Response;
import com.myolq.frame.bean.ErrorBean;
import com.myolq.frame.loader.callback.GsonCallBack;
import com.myolq.user.contract.ForgetPasswrodContract;
import com.myolq.user.model.ForgetPasswrodModel;

/**
 * Created by root on 2017-09-01.
 */

public class ForgetPasswrodPresenter implements ForgetPasswrodContract.Presenter{

    private ForgetPasswrodContract.View view;
    private final ForgetPasswrodModel model;

    public ForgetPasswrodPresenter(ForgetPasswrodContract.View view) {
        model = new ForgetPasswrodModel();
        this.view=view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void getRequestPasswordReset(String email ) {
        view.onLoadShow();
        model.getRequestPasswordReset(email, new GsonCallBack<ErrorBean>(new TypeToken<ErrorBean>(){}.getType()) {
            @Override
            public void onSuccess(ErrorBean errorBean) {
                view.onLoadCancel();
                view.onSuccess(errorBean);
            }

            @Override
            public void onError(Response response) {
                view.onLoadCancel();
            }
        });
//        model.getRequestPasswordReset(email, new StringCallBack() {
//            @Override
//            public void onSuccess(String s) {
//                view.onLoadCancel();
//                view.onSuccess(s);
//            }
//
//            @Override
//            public void onError(Response response) {
//                view.onLoadCancel();
//            }
//        });
    }

//    @Override
//    public void getIssue(String session) {
//
//    }


}
