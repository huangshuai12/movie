package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.CityZhanBean;
import com.bw.movie.mvp.contract.CityContract;
import com.bw.movie.mvp.model.CityModel;

import java.util.HashMap;

public class Citypresenter extends CityContract.Ccitypresenter {
    private final CityModel cityModel;
    private CityContract.CityView cityView;

    public Citypresenter(CityContract.CityView cityView) {
        this.cityView = cityView;
        cityModel = new CityModel();
    }


    @Override
    public void getCity(HashMap<String, String> map) {
        cityModel.getCity(map, new CityModel.RetorModelCallBack() {
            @Override
            public void Success(CityBean cityBean) {
                cityView.SuccessCity(cityBean);
            }
        });
    }

    @Override
    public void getCity1(HashMap<String, String> map) {
        cityModel.getCity1(map, new CityModel.RetorModelCallBack1() {
            @Override
            public void Success(CityLunBean cityLunBean) {
                cityView.SuccessCity1(cityLunBean);
            }
        });
    }

    @Override
    public void getCity2(HashMap<String, String> map) {
            cityModel.getCity2(map, new CityModel.RetorModelCallBack2() {
                @Override
                public void Success(CityZhanBean cityZhanBean) {
                    cityView.SuccessCity2(cityZhanBean);
                }
            });
    }
}
