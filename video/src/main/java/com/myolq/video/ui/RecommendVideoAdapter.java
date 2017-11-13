package com.myolq.video.ui;

import android.content.Context;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.myolq.video.R;
import com.myolq.video.bean.VideoBean;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;


/**
 * Created by root on 2017-09-29.
 */

public class RecommendVideoAdapter extends CommonAdapter<VideoBean.LivesBean> {

    private Context mContext;

    public RecommendVideoAdapter(Context context, List<VideoBean.LivesBean> datas) {
        super(context, R.layout.item_recommend_video, datas);
        mContext=context;
    }

    @Override
    protected void convert(ViewHolder holder, VideoBean.LivesBean livesBean, int position) {
        RoundedImageView ivHead=holder.getView(R.id.iv_head);
        TextView tvName=holder.getView(R.id.tv_name);
        TextView tvNick=holder.getView(R.id.tv_nick);
        TextView tvCity=holder.getView(R.id.tv_city);
        TextView tvNumber=holder.getView(R.id.tv_number);
        tvNumber.setText(livesBean.getOnline_users()+"人");
//        tvName.setText(livesBean.getName());
//        tvCity.setText(livesBean.getCity());
//        tvNick.setText(livesBean.getCreator().getNick());
//        GlideLoader.getInstance().init(mContext,livesBean.getCreator().getPortrait(),ivHead);

    }


}
