package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.GuanZhuBean;
import com.bw.movie.entity.QuBean;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.GuanContract;
import com.bw.movie.mvp.model.GuanModel;

import java.util.HashMap;

public class Guanpresenter extends GuanContract.Gguanpresenter {
    private final GuanModel guanModel;
    private GuanContract.GguanView gguanView;

    public Guanpresenter(GuanContract.GguanView gguanView) {
        this.gguanView = gguanView;
        guanModel = new GuanModel();
    }

    @Override
    public void getGuan(HashMap<String, String> map) {
       guanModel.getGuan(map, new GuanModel.RetorModelCallBack() {
           @Override
           public void Success(TuiBean tuiBean) {
               gguanView.SuccessGuan(tuiBean);
           }
       });
    }

    @Override
    public void getQu(HashMap<String, String> map) {
       guanModel.getQu(map, new GuanModel.RetorModelCallBack1() {
           @Override
           public void Success(TuiBean tuiBean) {
               gguanView.SuccessQu(tuiBean);
           }
       });
    }


}
