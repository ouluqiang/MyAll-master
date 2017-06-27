package com.olq.mytotal.book;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.myolq.frame.utils.L;
import com.myolq.frame.utils.ToastUtil;
import com.olq.mytotal.R;
import com.olq.mytotal.base.BaseFragment;
import com.olq.mytotal.bean.BookBean;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/1.
 */

public class BookFragment extends BaseFragment {


    @BindView(R.id.rv_re_cycler)
    RecyclerView rvReCycler;
    @BindView(R.id.srl_refresh)
    SwipeRefreshLayout srlRefresh;

    @Override
    public int getLayout() {
        return R.layout.fragment_book;
    }

    @Override
    public void onCreateView() {
        rvReCycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<BookBean> books = BookProvider.scanMusicFile(getActivity());
        L.log(books.toString());
        BookAdapter bookAdapter=new BookAdapter(getActivity(),books);
        rvReCycler.setAdapter(bookAdapter);
        bookAdapter.setOnItemClickListener(new BookAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast("点击"+position);
            }
        });
    }
}
