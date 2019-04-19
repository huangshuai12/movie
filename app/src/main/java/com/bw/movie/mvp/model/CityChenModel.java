package com.bw.movie.mvp.model;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityChengBean;
import com.bw.movie.mvp.contract.CityChenContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CityChenModel implements CityChenContract.CcityChenModel {


    @Override
    public void getCity(HashMap<String, String> map, final RetorCallBack retorCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getCheng(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CityChengBean>() {
                    @Override
                    public void accept(CityChengBean cityChengBean) throws Exception {
                       retorCallBack.Success(cityChengBean);
                    }
                });
    }

    public interface RetorCallBack{
        void Success(CityChengBean cityChengBean);
    }
}
