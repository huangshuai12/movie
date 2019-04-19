package com.bw.movie.mvp.presenter;

import com.bw.movie.mvp.contract.PingContract;
import com.bw.movie.mvp.model.PingModel;

import java.util.HashMap;

public class PingPresenter extends PingContract.PpingPresenter {
    private final PingModel pingModel;
    private PingContract.PpingView ppingView;

    public PingPresenter(PingContract.PpingView ppingView) {
        this.ppingView = ppingView;
        pingModel = new PingModel();
    }

    @Override
    public void getPing(HashMap<String, String> map) {
        pingModel.getPing(map, new PingModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                ppingView.SuccessPing(result);
            }
        });
    }
}
