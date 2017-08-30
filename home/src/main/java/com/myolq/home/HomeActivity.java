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
import android.widget.TextView;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.TitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;

@Router("home")
public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.tb_title)
    TitleBar tbTitle;
    @BindView(R.id.fl_view)
    FrameLayout flView;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
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
//        TextView tvUser=getViewId(navView,R.id.tv_user);
//        TextView tvUser= (TextView) navView.findViewById(R.id.tv_user);
//
////        ImageView ivUser=getViewId(navView,R.id.iv_user);
//        tvUser.setText("用户名");
        //        TextView tvUser=getViewId(navView,R.id.tv_user);
        View view=getLayoutInflater().inflate(R.layout.nav_header_home,null);
        final TextView tvUser= getViewId(navView.getHeaderView(0),R.id.tv_user);


//        final TextView tvUser= (TextView) view.findViewById(R.id.tv_user);
        tvUser.setText("用户名");
        tvUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvUser.setText("用户名");
                ToastUtil.show(getApplicationContext(),"dianji ");
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
