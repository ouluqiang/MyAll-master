package com.olq.mytotal.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myolq.frame.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/1/23.
 */

public abstract class BaseFragment extends Fragment {

    private View view;

    public abstract int getLayout();
    public abstract void  onCreateView();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view=null;
        if (view==null){
            view = inflater.inflate(getLayout(),null);
        }
        ButterKnife.bind(this,view);
        onCreateView();
        return view;
    }

    public void Toast(String message){
        ToastUtil.show(getActivity(),message);
    }


}
