package com.myolq.video.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.LogUtils;
import com.myolq.frame.utils.NetUtils;
import com.myolq.video.R;
import com.myolq.video.R2;
import com.myolq.video.bean.VideoBean;
import com.myolq.video.contract.RecommendVideoContract;
import com.myolq.video.presenter.RecommendVideoPresenter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Router(RouterConfig.RECOMMEND_VIDEO)
public class RecommendVideoActivity extends BaseActivity implements RecommendVideoContract.View{

    @BindView(R2.id.x_recycler)
    XRecyclerView xRecycler;

    RecommendVideoContract.Presenter presenter;
    private List<VideoBean.LivesBean> list;
    private RecommendVideoAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_recommend_video;
    }

    @Override
    public void onCreate() {
        showState(0);
        presenter= new RecommendVideoPresenter(this);
         xRecycler.setLayoutManager(new GridLayoutManager(this,2));
        list = new ArrayList<>();
        adapter = new RecommendVideoAdapter(this,  list);
        xRecycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                LogUtils.i(position+"----");
                Routers.open(getAContext(), RouterConfig.getPlay(list.get(position-1).getStream_addr(),list.get(position-1).getName()));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        xRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                if (!NetUtils.isConnected(getAContext())){
                    state(4);
                    return;
                }
                presenter.getRecommendVideo();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void onLayoutLoadData() {
        xRecycler.refresh();
    }

    @Override
    protected void onStart() {
        super.onStart();
        xRecycler.refresh();
    }

    @Override
    public void setPresenter(RecommendVideoContract.Presenter presenter) {

    }

    @Override
    public void onToast(String s) {

    }

    @Override
    public void onLoadShow() {

    }

    @Override
    public void onLoadCancel() {

    }

    @Override
    public void onSuccess(List<VideoBean.LivesBean> livesBean) {
        list.addAll(livesBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void state(int type) {
        showState(type);
    }

    @Override
    public void cancel() {
        xRecycler.refreshComplete();
    }

}
