package com.myolq.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.myolq.frame.utils.ScreenUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.LoadDialog;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayoutView();

    public abstract void onCreate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        ButterKnife.bind(this);
        onCreate();

    }

    /**
     * 隐藏状态栏
     */
    public void immersion() {
        ScreenUtils.immersion(this);
    }

    public <T extends View> T getViewId(int resId) {
        return (T) super.findViewById(resId);
    }

    public <T extends View> T getViewId(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    public <T extends View> T getViewId(int layout, int resId) {
        return (T) inflate(layout).findViewById(resId);
    }

    public View inflate(int layout) {
        return getLayoutInflater().inflate(layout, null);
    }

    public void LoadShow() {
        LoadDialog.getInstance(this).show();
    }

    public void LoadCancel() {
        LoadDialog.getInstance(this).cancel();
    }
    public void toast(String s) {
        ToastUtil.show(this,s);
    }


}
