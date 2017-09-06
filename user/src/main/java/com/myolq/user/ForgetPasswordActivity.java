package com.myolq.user;

import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.widget.TitleBar;
import com.myolq.user.contract.ForgetPasswrodContract;
import com.myolq.user.presenter.ForgetPasswrodPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 忘记密码
 */
@Router(RouterConfig.FORGET_PASSWORD)
public class ForgetPasswordActivity extends BaseActivity implements ForgetPasswrodContract.View {

    @BindView(R2.id.tb_title)
    TitleBar tbTitle;
    @BindView(R2.id.acs_issue)
    AppCompatSpinner acsIssue;
    @BindView(R2.id.et_answer)
    EditText etAnswer;
    private ForgetPasswrodContract.Presenter presenter;
    private String[] safetyIssues;
    private String issues;

    @Override
    public int getLayoutView() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void onCreate() {
        init();
    }

    private void init() {
        ForgetPasswrodPresenter p = new ForgetPasswrodPresenter(this);
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
    public void setPresenter(ForgetPasswrodContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLoadShow() {
        LoadShow();
    }

    @Override
    public void onLoadCancel() {
        onLoadCancel();
    }

    @Override
    public void onToast(String s) {
        toast(s);
    }

    @OnClick(R2.id.btn_confirm)
    public void onViewClicked() {
        String answer = etAnswer.getText().toString().trim();
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
//        presenter.getRequestPasswordReset(email);
    }

    @Override
    public void onSuccess(String s) {
        onLoadCancel();
    }
}
