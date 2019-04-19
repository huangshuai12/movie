package com.bw.movie.mvp.presenter;

import com.bw.movie.mvp.contract.XiangContract;
import com.bw.movie.mvp.model.XiangModel;

import java.util.HashMap;

public class Xiangpresenter extends XiangContract.Xxiangpresenter {

    private final XiangModel xiangModel;
    private XiangContract.XxiangView xxiangView;

    public Xiangpresenter(XiangContract.XxiangView xxiangView) {
        this.xxiangView = xxiangView;
        xiangModel = new XiangModel();
    }


    @Override
    public void getXiang(String userId, String sessionId, HashMap<String, String> map) {
        xiangModel.getXiang(userId, sessionId, map, new XiangModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                xxiangView.SuccessXiang(result);
            }
        });
    }
}
