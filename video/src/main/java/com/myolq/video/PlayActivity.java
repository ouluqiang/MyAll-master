package com.myolq.video;

import android.content.res.Configuration;
import android.view.View;
import android.widget.ImageView;

import com.dou361.ijkplayer.listener.OnPlayerBackListener;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;

import butterknife.BindView;

@Router(RouterConfig.PLAY)
public class PlayActivity extends BaseActivity {

    @BindView(R2.id.video_view)
    IjkVideoView videoView;
    private String url;
    private PlayerView player;

    @Override
    public int getLayoutView() {
        return R.layout.activity_play;
    }

    @Override
    public void onCreate() {
        url = getIntent().getStringExtra("url");
        String title=getIntent().getStringExtra("title");
        View view = getLayoutInflater().inflate(getLayoutView(), null);
        player = new PlayerView(this)
                .setTitle(title)
                .setScaleType(PlayStateParams.fitparent)
                .forbidTouch(false)
                .hideMenu(true)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
//                        Glide.with(this)
//                                .load("http://pic2.nipic.com/20090413/406638_125424003_2.jpg")
//                                .placeholder(R.color.cl_default)
//                                .error(R.color.cl_error)
//                                .into(ivThumbnail);
                    }
                })
                .setPlaySource(url)
                .setPlayerBackListener(new OnPlayerBackListener() {
                    @Override
                    public void onPlayerBack() {
                        //这里可以简单播放器点击返回键
                        finish();
                    }
                })
                .startPlay();
    }

    @Override
    public void onLayoutLoadData() {

    }


    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed() {
        if (player != null && player.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

}
