package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.LunBean;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.contract.LunContract;
import com.bw.movie.mvp.model.LoadModel;
import com.bw.movie.mvp.model.LunModel;

import java.util.HashMap;

public class Lunpresenter extends LunContract.Llunpresenter {

    private final LunModel lunModel;
    private LunContract.LlunView llunView;

    public Lunpresenter(LunContract.LlunView llunView) {
        this.llunView = llunView;
        lunModel = new LunModel();
    }

    @Override
    public void getLun(HashMap<String, String> map) {
        lunModel.getLun(map, new LunModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                llunView.SuccessLun(result);
            }
        });
    }

    @Override
    public void getRen(HashMap<String, String> map) {
        lunModel.getRen(map, new LunModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                llunView.SuccessRen(result);
            }
        });
    }

    @Override
    public void getLZheng(HashMap<String, String> map) {
    lunModel.getZheng(map, new LunModel.RetorModelCallBack() {
        @Override
        public void Success(Object result) {
            llunView.SuccessZheng(result);
        }
    });
    }

    @Override
    public void getJi(HashMap<String, String> map) {
        lunModel.getJi(map, new LunModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                llunView.SuccessJi(result);
            }
        });
    }
}
