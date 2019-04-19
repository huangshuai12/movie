package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.model.LoadModel;

import java.util.HashMap;

public class Loadpresenter extends LoadContract.Lloadpresenter {
    private final LoadModel loadModel;
    private LoadContract.LloadView lloadView;

    public Loadpresenter(LoadContract.LloadView lloadView) {
        this.lloadView = lloadView;
        loadModel = new LoadModel();
    }


    @Override
    public void getReg(HashMap<String, String> map) {
        loadModel.getReg(map, new LoadModel.RetorModelCallBack() {
            @Override
            public void Success(RegBean regBean) {
                lloadView.SuccessReg(regBean);
            }
        });
    }

    @Override
    public void getLogin(HashMap<String, String> map) {
        loadModel.getLogin(map, new LoadModel.RetorModelCallBack() {
            @Override
            public void Success(RegBean regBean) {
                lloadView.SuccessReg(regBean);
            }
        });
    }

    @Override
    public void getWeiXin(HashMap<String, String> map) {
        loadModel.getWeiXin(map, new LoadModel.RetorModelCallBack() {
            @Override
            public void Success(RegBean regBean) {
                lloadView.WeiXin(regBean);
            }
        });
    }
}
