package com.myolq.user.ui;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.user.R;

@Router(RouterConfig.USER_DETAILS)
public class UserDetailsActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_details;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onLayoutLoadData() {

    }


}
