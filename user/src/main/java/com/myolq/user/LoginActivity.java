package com.myolq.user;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.github.mzule.activityrouter.annotation.Router;
import com.github.mzule.activityrouter.router.Routers;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.LoadDialog;
import com.myolq.frame.widget.TitleBar;
import com.myolq.user.contract.LoginContract;
import com.myolq.user.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.myolq.frame.widget.Toolbar;

/**
 * A login screen that offers login via email/password.
 */
@Router(RouterConfig.LOGIN)
public class LoginActivity extends BaseActivity implements LoginContract.LoginView {


    @BindView(R2.id.tb_title)
    TitleBar tbTitle;
    @BindView(R2.id.actv_account)
    AutoCompleteTextView actvAccount;
    @BindView(R2.id.et_password)
    EditText etPassword;
    @BindView(R2.id.btn_register)
    Button btnRegister;
    private LoginContract.Presenter presenter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_login;
    }

    @Override
    public void onCreate() {
        ButterKnife.bind(this);
        init();
    }


    private void init() {
        LoginPresenter loginPresenter = new LoginPresenter(this, this);
        tbTitle.setTitle("登录");
        tbTitle.setOnClickLeftBack(this);
        onClicked();
    }

    public void onClicked() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                LoadDialog.getInstance(LoginActivity.this).show();
                Routers.open(getApplicationContext(), RouterConfig.getRegister());
            }
        });
    }


    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void onToast(String s) {
        ToastUtil.show(this, s);
    }

    @OnClick({R2.id.btn_login})
    public void onViewClicked(View view) {
        int id = view.getId();
        System.out.println(id + "---" + R2.id.btn_register);
        if (id == R.id.btn_login) {
            String account = actvAccount.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            if (CharacterUtils.isEmpty(account)) {
                onToast("账号不能为空");
                return;
            }
            if (CharacterUtils.isEmpty(password)) {
                onToast("密码不能为空");
                return;
            }
            presenter.getLogin(account, password);
//        UserBean userBean=new UserBean(account,password);
//        } else if (id == R2.id.btn_register) {
//
//            Routers.open(this, RouterConfig.getRegister());

        }
    }
}

