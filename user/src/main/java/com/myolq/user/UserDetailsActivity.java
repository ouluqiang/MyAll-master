package com.myolq.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;

@Router(RouterConfig.USER_DETAILS)
public class UserDetailsActivity extends BaseActivity {

    @Override
    public int getLayoutView() {
        return R.layout.activity_user_details;
    }

    @Override
    public void onCreate() {

    }


}
