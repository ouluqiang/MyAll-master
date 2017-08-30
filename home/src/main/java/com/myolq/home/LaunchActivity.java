package com.myolq.home;

import android.os.Handler;
import android.widget.TextView;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.config.RouterConfig;

import butterknife.BindView;

@Router(RouterConfig.LAUNCH)
public class LaunchActivity extends BaseActivity {

    @BindView(R.id.tv_time)
    TextView tvTime;

    private int time=3;

    @Override
    public int getLayoutView() {
        immersion();
        return R.layout.activity_launch;
    }

    @Override
    public void onCreate() {

        handler.post(runnable);
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
}
