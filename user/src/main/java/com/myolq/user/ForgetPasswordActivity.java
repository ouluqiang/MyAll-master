package com.myolq.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.config.RouterConfig;

/**
 * 忘记密码
 */
@Router(RouterConfig.FORGET_PASSWORD)
public class ForgetPasswordActivity extends BaseActivity {

    @Override
    public int getLayoutView() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void onCreate() {

    }

}
