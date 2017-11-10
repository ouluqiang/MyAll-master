package com.myolq.frame.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.myolq.frame.utils.ScreenUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.FlexibleLayout;
import com.myolq.frame.widget.LoadDialog;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/19.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private FlexibleLayout mFlexibleLayout;
    private AppManager mAppManager;

    public abstract int getLayoutId();

    public abstract void onCreate();
    public abstract void onLayoutLoadData();

    public  Context getAContext() {
        return aContext;
    }

    public  Context aContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        aContext=this;
        setContentView(getView());
        mAppManager= AppManager.getInstance();
        mAppManager.pushActivity(this);
        ButterKnife.bind(this);
        onCreate();

    }

    private View getView(){
        mFlexibleLayout = new FlexibleLayout(this) {
            @Override
            public ViewGroup getViewGroup() {
                return getLayoutInflaterViewGroup();
            }

            @Override
            public void onLoadData() {
                onLayoutLoadData();
            }
        };
        showState(1);
        return mFlexibleLayout;
    }

    private ViewGroup getLayoutInflaterViewGroup(){
        ViewGroup view= (ViewGroup) View.inflate(aContext,getLayoutId(),null);
        return view;
    }

    /**
     * 0成功
     * 1失败
     * 2加载
     * 3空数据
     * 4无网络
     * @param code
     */
    public void showState(int code) {
        switch (code) {
            case 0:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Load);
                break;
            case 1:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Succeed);
                break;
            case 2:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Error);
                break;
            case 3:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.Empty);
                break;
            case 4:
                mFlexibleLayout.showPageWithState(FlexibleLayout.State.NoNetWork);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAppManager.popActivity(this);
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

//    public <T extends View> T getViewId(int layout, int resId) {
//        return (T) inflate(layout).findViewById(resId);
//    }
//
//    public View inflate(int layout) {
//        return getLayoutInflater().inflate(layout, null);
//    }

    public void LoadShow() {
        LoadDialog.getInstance(this).show();
    }

    public void LoadCancel() {
        LoadDialog.getInstance(this).cancel();
    }
    public void toast(String s) {
        ToastUtil.show(this,s);
    }


    private long time = 0;

    public void exit() {
        //如果在两秒大于2秒
        if (System.currentTimeMillis() - time > 2000) {
            //获得当前的时间
            time = System.currentTimeMillis();
            toast("再按一次退出程序");
        } else {
            mAppManager.popAllActivity();
            System.exit(0);
        }
    }

}
