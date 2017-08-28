package com.myolq.user;

import android.widget.EditText;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.TopToolbar;
import com.myolq.user.bean.UserBean;
import com.myolq.user.contract.RegisterContract;
import com.myolq.user.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

@Router(RouterConfig.REGISTER)
public class RegisterActivity extends BaseActivity implements RegisterContract.RegisterView {

    @BindView(R2.id.ttl_title)
    TopToolbar ttlTitle;
    @BindView(R2.id.et_acount)
    EditText etAcount;
    @BindView(R2.id.et_password)
    EditText etPassword;
    private RegisterContract.Presenter presenter;

    @Override
    public int getLayoutView() {
        return R.layout.activity_register;
    }

    @Override
    public void onCreate() {
        init();
    }

    private void init() {
        RegisterPresenter registerPresenter=new RegisterPresenter(this);
        ttlTitle.setTitle("注册");
        ttlTitle.setOnClickLeftBack(this);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onToast(String s) {
        ToastUtil.show(this,s);
    }

    @OnClick(R2.id.btn_regitster)
    public void onViewClicked() {
        String account=etAcount.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        if (CharacterUtils.isEmpty(account)) {
            onToast("账号不能为空");
        }
        if (CharacterUtils.isEmpty(password)) {
            onToast("密码不能为空");
        }
        UserBean user=new UserBean(account,password);
        presenter.getRegister(user);
    }
}
