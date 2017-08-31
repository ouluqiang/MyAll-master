package com.myolq.frame.widget;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myolq.frame.R;

/**
 * Created by root on 2017-08-24.
 */
public class TitleBar extends LinearLayout {

    private Context mContext;
    private TextView tvTitle;
    private ImageView back;
    private String title;

    public Toolbar getToolbar() {
        back.setVisibility(GONE);
        return toolbar;
    }

    private Toolbar toolbar;

    public TitleBar(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getAttrs(attrs);
        initView();
    }

    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        getAttrs(attrs);
        initView();
    }

    private void getAttrs(AttributeSet attrs){
        TypedArray ta= mContext.obtainStyledAttributes(attrs,R.styleable.TitleBar);
        title = ta.getString(R.styleable.TitleBar_title);
        ta.recycle();
    }

    private void initView() {

        View mView = inflate(mContext, R.layout.widget_toolbar, this);
        toolbar = (Toolbar) mView.findViewById(R.id.toolbar);
        toolbar.setTitle("");
        tvTitle = (TextView) mView.findViewById(R.id.title);
        tvTitle.setText(title);
        back = (ImageView) mView.findViewById(R.id.back);
    }

    public void setTitle(CharSequence s) {
        tvTitle.setText(s);
    }

    public void setOnClickLeftBack(final Activity activity) {
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }



}
