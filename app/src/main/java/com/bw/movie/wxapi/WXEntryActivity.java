package com.bw.movie.wxapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.presenter.Loadpresenter;
import com.bw.movie.mvp.view.ShowActivity;
import com.bw.movie.net.SpUtils;
import com.bw.movie.ui.WeiXinUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import java.util.HashMap;

public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler,LoadContract.LloadView{
    private Loadpresenter loadpresenter;
    private String code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);
        getSupportActionBar().hide();
        WeiXinUtil.reg(WXEntryActivity.this).handleIntent(getIntent(),this);
    }

    @Override
    public void onReq(final BaseReq baseResq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_OK:
                code = ((SendAuth.Resp) baseResp).code;
                //p层请求加入参数code值
                loadpresenter=new Loadpresenter(this);
                HashMap<String,String> map = new HashMap<>();
                map.put("code",code);
                loadpresenter.getWeiXin(map);
                break;
            default:
                break;
        }
    }
    @Override
    public void SuccessReg(RegBean regBean) {

    }

    @Override
    public void WeiXin(RegBean regBean) {
        Toast.makeText(this, regBean.getMessage()+"", Toast.LENGTH_SHORT).show();
        if (regBean.getStatus().equals("0000")){
            startActivity(new Intent(WXEntryActivity.this,ShowActivity.class));
            SpUtils.getInstance().saveData("userId", regBean.getResult().getUserId() + "");
            SpUtils.getInstance().saveData("sessionId", regBean.getResult().getSessionId() + "");

        }
    }
}
