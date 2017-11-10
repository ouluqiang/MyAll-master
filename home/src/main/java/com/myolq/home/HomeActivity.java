package com.myolq.home;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.config.UserConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.widget.TitleBar;
import com.tencent.bugly.beta.Beta;

import butterknife.BindView;
import butterknife.OnClick;

@Router(RouterConfig.HOME)
public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R2.id.tb_title)
    TitleBar tbTitle;
    @BindView(R2.id.fl_view)
    FrameLayout flView;
    @BindView(R2.id.nav_view)
    NavigationView navView;
    @BindView(R2.id.drawer_layout)
    DrawerLayout drawerLayout;
    private TextView tvUser;
    private FragmentTransaction fragmentTransaction;
    private NewspaperFragment newspaperFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate() {
        init();
    }

    @Override
    public void onLayoutLoadData() {
        showState(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Beta.autoInit = true;
        Beta.init(getApplicationContext(), true);
//        Beta.autoCheckUpgrade = true;
        Beta.initDelay = 1 * 1000;  //默认一秒后显示更新弹窗
        if (CharacterUtils.isEmpty(UserConfig.getBoy())) {
            tvUser.setText("用户名");
        } else {
            tvUser.setText(UserConfig.getBoy());
        }
    }


    private void init() {
        tbTitle.setTitle("首页");
//        setSupportActionBar(tbTitle.getToolbar());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, tbTitle.getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        getHeadView();
        showFragment(0);
    }

    private void getHeadView() {
        tvUser = getViewId(navView.getHeaderView(0), R.id.tv_user);
        ImageView ivUser = getViewId(navView.getHeaderView(0), R.id.iv_user);
        LinearLayout llUser = getViewId(navView.getHeaderView(0), R.id.ll_user);

        llUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CharacterUtils.isEmpty(UserConfig.getSession(getApplication()))) {
                    Routers.open(HomeActivity.this, RouterConfig.getLogin());
                } else {
                    Routers.open(HomeActivity.this, RouterConfig.getUserDetails());

                }
            }
        });

    }

    @OnClick({R2.id.tb_title, R2.id.acrb_newspaper})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tb_title:
                break;
            case R.id.acrb_newspaper:
                showFragment(0);
                break;
        }
    }

    public void showFragment(int type) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        switch (type) {
            case 0:
                if (newspaperFragment == null) {
                    newspaperFragment = NewspaperFragment.newInstance();
                    fragmentTransaction.add(R.id.fl_view, newspaperFragment);
                } else {
                    fragmentTransaction.show(newspaperFragment);
                }
                break;
            case 1:

                break;
            case 2:

                break;
        }
        fragmentTransaction.commit();

    }

    private void hideFragment(FragmentTransaction transaction) {
        if (newspaperFragment != null) {
            transaction.hide(newspaperFragment);
        }
    }


    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            exit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    @OnClick(R2.id.tv_video)
//    public void onViewClicked() {
////        toast("点击了");
//        toast("热更新成功");
////        Routers.open(this,RouterConfig.getRecommendVideo());
//    }


}
