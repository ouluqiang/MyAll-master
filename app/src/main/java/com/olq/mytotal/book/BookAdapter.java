package com.olq.mytotal.book;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olq.mytotal.R;
import com.olq.mytotal.bean.BookBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/1.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.Holder> {

    private Context mContext;
    private List<BookBean> list;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public BookAdapter(Context mContext, List<BookBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_book,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        holder.tvTitle.setText(list.get(position).getTitle());
        holder.tvSize.setText(list.get(position).getSize());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onItemClickListener.onItemClick(view,position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_size)
        TextView tvSize;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnItemClickListener{
       void onItemClick(View view,int position);
    }
    public interface OnItemLongClickListener{
       void onItemLongClick(View view,int position);
    }


}
