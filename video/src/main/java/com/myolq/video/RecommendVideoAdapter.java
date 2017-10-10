package com.myolq.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.myolq.frame.loader.GlideLoader;
import com.myolq.video.bean.VideoBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;


/**
 * Created by root on 2017-09-29.
 */

public class RecommendVideoAdapter extends CommonAdapter<VideoBean.LivesBean> {

    private Context mContext;

    public RecommendVideoAdapter(Context context, int layoutId, List<VideoBean.LivesBean> datas) {
        super(context, layoutId, datas);
        mContext=context;
    }

    @Override
    protected void convert(ViewHolder holder, VideoBean.LivesBean livesBean, int position) {
        RoundedImageView ivHead=holder.getView(R.id.iv_head);
        TextView tvName=holder.getView(R.id.tv_name);
        TextView tvNick=holder.getView(R.id.tv_nick);
        TextView tvCity=holder.getView(R.id.tv_city);
        TextView tvNumber=holder.getView(R.id.tv_number);
        tvNumber.setText(livesBean.getOnline_users());
        tvName.setText(livesBean.getName());
        tvCity.setText(livesBean.getCity());
        tvNick.setText(livesBean.getCreator().getNick());
        GlideLoader.getInstance().init(mContext,livesBean.getCreator().getPortrait(),ivHead);
    }


}
