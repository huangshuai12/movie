package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.CityChengBean;
import com.bw.movie.mvp.contract.CityChenContract;
import com.bw.movie.mvp.model.CityChenModel;

import java.util.HashMap;

public class CityChenpresenter extends CityChenContract.CcityChenpresenter {
    private final CityChenModel cityChenModel;
    private CityChenContract.CityChenView cityChenView;

    public CityChenpresenter(CityChenContract.CityChenView cityChenView) {
        this.cityChenView = cityChenView;
        cityChenModel = new CityChenModel();
    }

    @Override
    public void getCity(final HashMap<String, String> map) {
        cityChenModel.getCity(map, new CityChenModel.RetorCallBack() {
            @Override
            public void Success(CityChengBean cityChengBean) {
                cityChenModel.getCity(map, new CityChenModel.RetorCallBack() {
                    @Override
                    public void Success(CityChengBean cityChengBean) {
                        cityChenView.SuccessCityChen(cityChengBean);
                    }
                });
            }
        });
    }
}
