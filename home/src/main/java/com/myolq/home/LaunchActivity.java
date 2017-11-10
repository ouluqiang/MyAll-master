package com.myolq.home;

import android.os.Handler;
import android.widget.TextView;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.bean.UserBean;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.config.UserConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.home.contract.LaunchContract;
import com.myolq.home.presenter.LaunchPresenter;

import butterknife.BindView;

@Router(RouterConfig.LAUNCH)
public class LaunchActivity extends BaseActivity implements LaunchContract.View{

    @BindView(R2.id.tv_time)
    TextView tvTime;
    private int time=3;
    private LaunchContract.Presenter presenter;

    @Override
    public int getLayoutId() {
//        immersion();
        return R.layout.activity_launch;
    }

    @Override
    protected void onStart() {
        super.onStart();
        String session=UserConfig.getSession(this);
        if (!CharacterUtils.isEmpty(session)){
            presenter.getMe(session);
        }
    }

    @Override
    public void onCreate() {
        init();
        handler.post(runnable);
    }

    @Override
    public void onLayoutLoadData() {

    }

    private void init() {
        presenter=new LaunchPresenter(this);

    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tvTime.setText("倒数"+time+"秒");
            if (time<=1){
                Routers.open(getApplicationContext(),RouterConfig.getHome());
                finish();
            }else{
                time--;
                handler.postDelayed(runnable, 1000);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler!=null&&runnable!=null){
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void setPresenter(LaunchContract.Presenter presenter) {
    }

    @Override
    public void onToast(String s) {
        ToastUtil.show(this, s);
    }


    @Override
    public void onLoadShow() {
        LoadShow();
    }

    @Override
    public void onLoadCancel() {
        LoadCancel();
    }


    @Override
    public void onSuccess(UserBean userBean) {
        if (userBean!=null&&userBean.getCode()==null){
            UserConfig.setUser(userBean.getObjectId(),userBean.getUsername(),userBean.getBoy(),userBean.getEmail(),userBean.isEmailVerified());
        }else{
            UserConfig.clearUser(this);
        }

    }
}
