package com.myolq.user;

import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.utils.LogUtils;
import com.myolq.frame.utils.RegexUtils;
import com.myolq.frame.utils.ToastUtil;
import com.myolq.frame.widget.TitleBar;
import com.myolq.user.bean.UserBean;
import com.myolq.user.contract.RegisterContract;
import com.myolq.user.presenter.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 */
@Router(RouterConfig.REGISTER)
public class RegisterActivity extends BaseActivity implements RegisterContract.View {

    @BindView(R2.id.tb_title)
    TitleBar tbTitle;
    @BindView(R2.id.et_acount)
    EditText etAcount;
    @BindView(R2.id.et_password)
    EditText etPassword;
    @BindView(R2.id.et_password_new)
    EditText etPasswordNew;
    @BindView(R2.id.et_email)
    EditText etEmail;
    @BindView(R2.id.acs_issue)
    AppCompatSpinner acsIssue;
    @BindView(R2.id.et_answer)
    EditText etAnswer;
    @BindView(R2.id.et_boy)
    EditText etBoy;
    private RegisterContract.Presenter presenter;
    private String issues;
    private String[] safetyIssues;

    @Override
    public int getLayoutView() {
        return R.layout.activity_register;
    }

    @Override
    public void onCreate() {
        init();
    }

    private void init() {
        RegisterPresenter registerPresenter = new RegisterPresenter(this);
        tbTitle.setTitle("注册");
        tbTitle.setOnClickLeftBack(this);
        safetyIssues = getResources().getStringArray(R.array.safety_issue);
        acsIssue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                issues = safetyIssues[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onToast(String s) {
        ToastUtil.show(this, s);
    }

    @Override
    public void onFinish() {
        onLoadCancel();
        finish();
    }

    @Override
    public void onLoadShow() {
        LoadShow();
    }

    @Override
    public void onLoadCancel() {
        LoadCancel();
    }

    @OnClick(R2.id.btn_register)
    public void onViewClicked() {
        String account = etAcount.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String passwordNew = etPasswordNew.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String answer = etAnswer.getText().toString().trim();
        String boy = etBoy.getText().toString().trim();
        if (CharacterUtils.isEmpty(account)) {
            onToast("账号不能为空");
            return;
        }
        if (!CharacterUtils.isLengthMin(account, 6)) {
            onToast("账号不能小于6位");
            return;
        }
        if (CharacterUtils.isEmpty(password)) {
            onToast("密码不能为空");
            return;
        }
        if (!CharacterUtils.isLengthMin(password, 6)) {
            onToast("密码不能小于6位");
            return;
        }
        if (CharacterUtils.isEmpty(passwordNew)) {
            onToast("密码不能为空");
            return;
        }
        if (!CharacterUtils.isLengthMin(passwordNew, 6)) {
            onToast("密码不能小于6位");
            return;
        }
        if (!CharacterUtils.equals(password, passwordNew)) {
            onToast("密码不一致");
            return;
        }

        if (CharacterUtils.isEmpty(boy)) {
            onToast("昵称不能为空");
            return;
        }
        if (CharacterUtils.isEmpty(email)) {
            onToast("邮箱地址不能为空");
            return;
        }
        if (!RegexUtils.checkEmail(email)) {
            onToast("邮箱地址格式不正确");
            return;
        }
        if (CharacterUtils.equals(issues, safetyIssues[0])) {
            onToast("请选择安全问题");
            return;
        }
        if (CharacterUtils.isEmpty(answer)) {
            onToast("安全答案不能为空");
            return;
        }
        if (!CharacterUtils.isLengthMin(answer, 2)) {
            onToast("安全答案不能小于2位");
            return;
        }
        UserBean user = new UserBean(account, password, boy, email, issues, answer);
        LogUtils.i(user.toString());
        presenter.getRegister(user);
    }
}
