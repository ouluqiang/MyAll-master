package com.myolq.frame.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.myolq.frame.R;
import com.myolq.frame.utils.ToastUtil;

/**
 * Created by dell on 2017/11/7.
 */

public abstract class FlexibleLayout extends LinearLayout{

    private Context mContext;
    private ViewGroup initView;
    private View loadView;
    private View errorView;
    private View emptyView;
    private View noNetWorkView;
    private View title;

    public FlexibleLayout(Context context) {
        super(context);
        this.mContext=context;
        init();
    }

    public FlexibleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        init();
    }

    public FlexibleLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        init();
    }

    public abstract ViewGroup getViewGroup();
    public abstract void onLoadData();

    private void init(){
        setOrientation(VERTICAL);
        inflate(mContext, R.layout.widget_flexible,this);
        initView = getViewGroup();
        title = initView.findViewWithTag("title");
        addView(initView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public void loadData(){
        showPageWithState(State.Load);
        onLoadData();
    }


    @SuppressLint("RestrictedApi")
    public void showPageWithState(State status){
        if (status != State.Succeed && title != null) {
            String tag = (String) getChildAt(0).getTag();
            if (TextUtils.equals(tag, "title")) {
                //已经有标题栏
            } else {
                initView.removeView(title);
                addView(title, 0);
            }
        }
         switch (status){
            case Succeed:
                initView.setVisibility(VISIBLE);
                if (emptyView!=null){
                    emptyView.setVisibility(GONE);
                }
                if (errorView!=null){
                    errorView.setVisibility(GONE);
                }
                if (noNetWorkView!=null){
                    noNetWorkView.setVisibility(GONE);
                }
                if (loadView!=null){
                    loadView.setVisibility(GONE);
                }
                break;
            case Load:
                initView.setVisibility(GONE);
                if (emptyView!=null){
                    emptyView.setVisibility(GONE);
                }
                if (errorView!=null){
                    errorView.setVisibility(GONE);
                }
                if (noNetWorkView!=null){
                    noNetWorkView.setVisibility(GONE);
                }
                if (loadView==null){
                    ViewStubCompat vs= (ViewStubCompat) findViewById(R.id.vs_load);
                    loadView = vs.inflate();
                }else{
                    loadView.setVisibility(VISIBLE);
                }
                break;
            case Empty:
                initView.setVisibility(GONE);
                if (loadView!=null){
                    loadView.setVisibility(GONE);
                }
                if (errorView!=null){
                    errorView.setVisibility(GONE);
                }
                if (noNetWorkView!=null){
                    noNetWorkView.setVisibility(GONE);
                }
                if (emptyView==null){
                    ViewStubCompat vs= (ViewStubCompat) findViewById(R.id.vs_empty);
                    emptyView = vs.inflate();
                    emptyView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(mContext,"dianji");
                            loadData();
                        }
                    });
                }else{
                    emptyView.setVisibility(VISIBLE);
                }
                break;
            case Error:
                initView.setVisibility(GONE);
                if (loadView!=null){
                    loadView.setVisibility(GONE);
                }
                if (emptyView!=null){
                    emptyView.setVisibility(GONE);
                }
                if (noNetWorkView!=null){
                    noNetWorkView.setVisibility(GONE);
                }
                if (errorView==null){
                    ViewStubCompat vs= (ViewStubCompat) findViewById(R.id.vs_error);
                    errorView = vs.inflate();
                    errorView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(mContext,"dianji");
                            loadData();
                        }
                    });
                }else{
                    errorView.setVisibility(VISIBLE);
                }
                break;
            case NoNetWork:
                initView.setVisibility(GONE);
                if (loadView!=null){
                    loadView.setVisibility(GONE);
                }
                if (emptyView!=null){
                    emptyView.setVisibility(GONE);
                }
                if (errorView!=null){
                    errorView.setVisibility(GONE);
                }
                if (noNetWorkView==null){
                    ViewStubCompat vs= (ViewStubCompat) findViewById(R.id.vs_no_net_work);
                    noNetWorkView = vs.inflate();
                    noNetWorkView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.show(mContext,"dianji");
                            loadData();
                        }
                    });
                }else{
                    noNetWorkView.setVisibility(VISIBLE);
                }

                break;
            default:

                break;

        }
    }



    public enum State{
        Succeed,Error,Empty,Load,NoNetWork
    }

}
