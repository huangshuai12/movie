package com.bw.movie.mvp.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.RegBean;
import com.bw.movie.md5.EncryptUtil;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.presenter.Loadpresenter;
import com.bw.movie.net.SpUtils;
import com.bw.movie.ui.WeiXinUtil;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoadContract.LloadView {


    CheckBox mCheckRemember;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_pass)
    EditText editPass;
    @BindView(R.id.image_eye)
    ImageView imageEye;
    @BindView(R.id.check_remember)
    CheckBox checkRemember;
    @BindView(R.id.button_login)
    TextView buttonLogin;
    @BindView(R.id.reg)
    Button reg;
    @BindView(R.id.login_weixin)
    ImageView loginWeixin;
    private boolean isHideFirst;
    private SharedPreferences.Editor edit;
    private Loadpresenter loadpresenter;
    private SharedPreferences sp;
    private String password = "";
    private int remamberFlag = 0;
    private String sessionId;
    private int userId;
    private String phone;
    private String pwd;
    private SharedPreferences.Editor editor;
    private SpUtils spfUtil;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        loadpresenter = new Loadpresenter(this);

//        loginWeixin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        if (sharedPreferences != null) {
            String name = sharedPreferences.getString("name", "");
            password = sharedPreferences.getString("password", "");
            remamberFlag = sharedPreferences.getInt("remeber_flag", 0);
            editPhone.setText(name);

            // Intent intent = new Intent(LoginActivity.this, RegActivity.class);
            // startActivity(intent);
        }
        if (remamberFlag == 1) {
            checkRemember.setChecked(true);
            editPass.setText(password);
        }

    }


    @OnClick({R.id.image_eye, R.id.button_login, R.id.login_weixin, R.id.reg})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image_eye:
                if (!isHideFirst) {
                    editPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    isHideFirst = false;
                } else {
                    editPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    isHideFirst = true;
                }
                break;
            case R.id.button_login:
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.login_weixin:
                if (!WeiXinUtil.success(LoginActivity.this)) {
                    Toast.makeText(LoginActivity.this, "请先安装应用", Toast.LENGTH_SHORT).show();
                } else {
                    //  验证
                    Toast.makeText(LoginActivity.this, "ssss", Toast.LENGTH_SHORT).show();
                    SendAuth.Req req = new SendAuth.Req();
                    req.scope = "snsapi_userinfo";
                    req.state = "wechat_sdk_demo_test";
                    WeiXinUtil.reg(LoginActivity.this).sendReq(req);
                }
                break;
            case R.id.reg:
                HashMap<String, String> hashMap = new HashMap<String, String>();
                phone = editPhone.getText().toString();
                pwd = EncryptUtil.encrypt(editPass.getText().toString());
                hashMap.put("phone", phone);
                hashMap.put("pwd", pwd);
                ok();

                if (phone == null) {
                    Toast.makeText(this, "名字或密码为空", Toast.LENGTH_LONG).show();
                    return;
                } else if (pwd == null) {
                    Toast.makeText(this, "名字或密码为空", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    loadpresenter.getLogin(hashMap);
                }
                editor.commit();
                break;
        }
    }

    private void ok() {
        SharedPreferences sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String s = editPass.getText().toString();
        editor.putString("name", phone);
        editor.putString("pwd", s);

        if (checkRemember.isChecked()) {
            remamberFlag = 1;
            editor.putInt("remeber_flag", remamberFlag);
            editor.putString("password", s);
        } else {
            remamberFlag = 0;
            editor.putInt("remeber_flag", remamberFlag);
        }
    }


    @Override
    public void SuccessReg(RegBean regBean) {
        RegBean regBean1 = regBean;
        if (regBean1.getMessage().equals("登陆成功")) {
            sessionId = regBean.getResult().getSessionId();
            userId = regBean.getResult().getUserId();
            spfUtil.getInstance().saveData("userId", regBean.getResult().getUserId() + "");
            spfUtil.getInstance().saveData("sessionId", regBean.getResult().getSessionId() + "");

            startActivity(new Intent(this, ShowActivity.class));
            Toast.makeText(this, regBean1.getMessage() + "", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void WeiXin(RegBean regBean) {
        Toast.makeText(LoginActivity.this, regBean.getMessage() + "", Toast.LENGTH_LONG).show();
    }


    @OnClick(R.id.login_weixin)
    public void onViewClicked() {
    }
}
