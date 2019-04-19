package com.bw.movie.mvp.presenter;

import com.bw.movie.mvp.contract.MiddleContract;
import com.bw.movie.mvp.model.MiddleModel;

import java.util.HashMap;

public class Middlepresenter extends MiddleContract.Moddilepresenter {
    private final MiddleModel middleModel;
    private MiddleContract.ModdileView moddileView;

    public Middlepresenter(MiddleContract.ModdileView moddileView) {
        this.moddileView = moddileView;
        middleModel = new MiddleModel();
    }


    @Override
    public void getTui(HashMap<String, String> map) {
        middleModel.getTui(map, new MiddleModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                moddileView.SuccessTui(result);
            }
        });
    }

    @Override
    public void getFu(HashMap<String, String> map) {
        middleModel.getFu(map, new MiddleModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                moddileView.SuccessFu(result);
            }
        });
    }

    @Override
    public void getGuan(HashMap<String, String> map) {
        middleModel.getGuan(map, new MiddleModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                moddileView.SuccessGuan(result);
            }
        });
    }

    @Override
    public void getQu(HashMap<String, String> map) {
        middleModel.getQu(map, new MiddleModel.RetorModelCallBack() {
            @Override
            public void Success(Object result) {
                moddileView.SuccessQu(result);
            }
        });
    }
}
