package com.bw.movie.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.RegBean;
import com.bw.movie.md5.EncryptUtil;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.presenter.Loadpresenter;
import com.bw.movie.net.ValidatorUri;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends AppCompatActivity implements LoadContract.LloadView {

    @BindView(R.id.image_id1)
    ImageView imageId1;
    @BindView(R.id.name_reg)
    EditText nameReg;
    @BindView(R.id.image_id2)
    ImageView imageId2;
    @BindView(R.id.sex_reg)
    EditText sexReg;
    @BindView(R.id.image_id3)
    ImageView imageId3;
    @BindView(R.id.date)
    EditText date;
    @BindView(R.id.image_id4)
    ImageView imageId4;
    @BindView(R.id.phone_reg)
    EditText phoneReg;
    @BindView(R.id.image_id5)
    ImageView imageId5;
    @BindView(R.id.eimal_reg)
    EditText eimalReg;
    @BindView(R.id.image_id6)
    ImageView imageId6;
    @BindView(R.id.password_reg)
    EditText passwordReg;
    @BindView(R.id.button_reg)
    Button buttonReg;
    private Loadpresenter loadpresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);
        loadpresenter = new Loadpresenter(this);
    }

    public void Reg(View view) {



        String name = nameReg.getText().toString().trim();
        String sex = sexReg.getText().toString().trim();
        String date1 = date.getText().toString().trim();
        String phone1 = phoneReg.getText().toString().trim();
        final String email1 = eimalReg.getText().toString().trim();
        final String pwd1 = EncryptUtil.encrypt(passwordReg.getText().toString().trim());
        final String pwd2 = EncryptUtil.encrypt(passwordReg.getText().toString().trim());
        /*if (!ValidatorUri.isNull(name)){
            Toast.makeText(this,"名字为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (!ValidatorUri.isNull(sex)){
            Toast.makeText(this,"性别为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (!ValidatorUri.isNull(date1)){
            Toast.makeText(this,"年龄为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (!ValidatorUri.isNull(phone1)){
            Toast.makeText(this,"手机号为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (!ValidatorUri.isNull(email1)){
            Toast.makeText(this,"eaimal为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (!ValidatorUri.isNull(pwd1)){
            Toast.makeText(this,"密码为空",Toast.LENGTH_LONG).show();
            return;
        }*/

        HashMap<String,String> map = new HashMap<>();
        map.put("nickName",name);
        map.put("sex",sex);
        map.put("birthday",date1);
        map.put("phone",phone1);
        map.put("email",email1);
        map.put("pwd",pwd1);
        map.put("pwd2",pwd2);
        if (phone1==null){
            Toast.makeText(RegActivity.this,"为空",Toast.LENGTH_LONG).show();
        }
        loadpresenter.getReg(map);

        /*       Toast.makeText(this, "121", Toast.LENGTH_SHORT).show();*/
    }


    @Override
    public void SuccessReg(RegBean regBean) {
        Toast.makeText(this, regBean.getMessage() + "", Toast.LENGTH_SHORT).show();
        if (regBean.getMessage().equals("注册成功")) {
            Intent intent = new Intent(RegActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,  "没有输入值", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void WeiXin(RegBean regBean) {

    }


}
