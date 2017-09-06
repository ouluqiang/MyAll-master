package com.myolq.frame.base;

/**
 * Created by Administrator on 2017/6/19.
 */

public interface BaseView<T> {

    void setPresenter(T t);

    void onToast(String s);
    void onLoadShow();
    void onLoadCancel();
}
