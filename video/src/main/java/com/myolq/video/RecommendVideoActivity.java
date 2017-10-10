package com.myolq.video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.LogUtils;
import com.myolq.video.bean.VideoBean;
import com.myolq.video.contract.RecommendVideoContract;
import com.myolq.video.presenter.RecommendVideoPresenter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Router(RouterConfig.RECOMMEND_VIDEO)
public class RecommendVideoActivity extends BaseActivity implements RecommendVideoContract.View{

    String url = "http://service.inke.com/api/live/aggregation?imsi=&uid=147970465&proto=6&idfa=3EDE83E7-9CD1-4186-9F37-EE77B7423265&lc=0000000000000027&cc=TG0001&imei=&sid=20tJHn0JsxdmOGkbNjpEjo3DIKFyoyboTrCjMvP7zNxofi1QNXT&cv=IK3.2.00_Iphone&devi=134a83cdf2e6701fa8f85c099c5e68ac3ea7bd4b&conn=Wifi&ua=Android%205s&idfv=5CCB6FE7-1F0F-4288-90DC-946D6F6C45C2&osversion=ios_9.300000&interest=1&location=0";
    @BindView(R2.id.x_recycler)
    XRecyclerView xRecycler;
//    String url="http://service.inke.com/api/live/aggregation?imsi=&uid=147970465&proto=6&idfa=3EDE83E7-9CD1-4186-9F37-EE77B7423265&lc=0000000000000027&cc=TG0001&imei=&sid=20tJHn0JsxdmOGkbNjpEjo3DIKFyoyboTrCjMvP7zNxofi1QNXT&cv=IK3.2.00_Iphone&devi=134a83cdf2e6701fa8f85c099c5e68ac3ea7bd4b&conn=Wifi&ua=iPhone%205s&idfv=5CCB6FE7-1F0F-4288-90DC-946D6F6C45C2&osversion=ios_9.300000&interest=1&location=0";
    RecommendVideoContract.Presenter presenter;
    private List<VideoBean.LivesBean> list;
    private RecommendVideoAdapter adapter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_recommend_video;
    }

    @Override
    public void onCreate() {
        new RecommendVideoPresenter(this);
         xRecycler.setLayoutManager(new GridLayoutManager(this,2));
        list = new ArrayList<>();
        adapter = new RecommendVideoAdapter(this, R.layout.item_recommend_video, list);
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
                presenter.getRecommendVideo();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        xRecycler.refresh();
    }

    @Override
    public void setPresenter(RecommendVideoContract.Presenter presenter) {
        this.presenter=presenter;
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

}
