package com.myolq.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

@Router("home")
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

    @Override
    public int getLayoutView() {
        return R.layout.activity_home;
    }

    @Override
    public void onCreate() {
        init();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        ButterKnife.bind(this);
//
//
//    }

    private void init() {
        tbTitle.setTitle("首页");
//        setSupportActionBar(tbTitle.getToolbar());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, tbTitle.getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
        getHeadView();
    }

    private void getHeadView() {
         TextView tvUser= getViewId(navView.getHeaderView(0),R.id.tv_user);
         ImageView ivUser= getViewId(navView.getHeaderView(0),R.id.iv_user);
         LinearLayout llUser= getViewId(navView.getHeaderView(0),R.id.ll_user);
        tvUser.setText("用户名");
        llUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Routers.open(getApplication(), RouterConfig.getLogin());
            }
        });

    }

    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
}
