package com.myolq.user;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.github.mzule.activityrouter.annotation.Router;
import com.myolq.frame.base.BaseActivity;
import com.myolq.frame.bean.ErrorBean;
import com.myolq.frame.config.RouterConfig;
import com.myolq.frame.utils.CharacterUtils;
import com.myolq.frame.utils.DialogUtils;
import com.myolq.frame.utils.LogUtils;
import com.myolq.frame.utils.RegexUtils;
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
    @BindView(R2.id.et_email)
    EditText etEmail;
    private ForgetPasswrodContract.Presenter presenter;

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
        LoadCancel();
    }

    @Override
    public void onToast(String s) {
        toast(s);
    }

    @OnClick(R2.id.btn_confirm)
    public void onViewClicked() {
        String email = etEmail.getText().toString().trim();
        if (CharacterUtils.isEmpty(email)) {
            onToast("邮箱地址不能为空");
            return;
        }
        if (!RegexUtils.checkEmail(email)) {
            onToast("邮箱地址错误");
            return;
        }
        presenter.getRequestPasswordReset(email);
    }

    @Override
    public void onSuccess(ErrorBean errorBean) {

        if (errorBean.getCode()==null){
            new DialogUtils(this).setMessage("邮件发送成功，请修改密码")
                    .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                        }
                    }).setCancelable(false).show();
        }else{
            onToast(errorBean.getError());
        }
    }
}
