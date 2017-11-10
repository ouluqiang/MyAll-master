package com.myolq.frame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myolq.frame.widget.FlexibleLayout;

/**
 * Created by dell on 2017/11/9.
 */

public abstract class BaseFragment extends Fragment{

    private FlexibleLayout mFlexibleLayout;

    public abstract int getLayoutId();
    public abstract void onCreateView();
    public abstract void onLayoutLoadData();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=getLayout(inflater,container);
        onCreateView();
        return view;

    }

    private View getLayout(final LayoutInflater inflater, final ViewGroup container){
        mFlexibleLayout = new FlexibleLayout(getActivity()) {
            @Override
            public ViewGroup getViewGroup() {
                return getLayoutInflaterViewGroup(inflater,container);
            }

            @Override
            public void onLoadData() {
                onLayoutLoadData();
            }
        };
        showState(1);
        return mFlexibleLayout;
    }

    private ViewGroup getLayoutInflaterViewGroup(LayoutInflater inflater, ViewGroup container){
        ViewGroup view= (ViewGroup) inflater.inflate(getLayoutId(), container,false);

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

}
