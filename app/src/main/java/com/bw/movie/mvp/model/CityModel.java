package com.bw.movie.mvp.model;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.CityZhanBean;
import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.contract.CityContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class CityModel implements CityContract.CcityModel {

    @Override
    public void getCity(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getCity(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CityBean>() {
                    @Override
                    public void accept(CityBean cityBean) throws Exception {
                     retorModelCallBack.Success(cityBean);
                    }
                });
    }

    @Override
    public void getCity1(HashMap<String, String> map, final RetorModelCallBack1 retorModelCallBack1) {
        RetorUtils.getStanice().create(UserService.class)
                .getCity1(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CityLunBean>() {
                    @Override
                    public void accept(CityLunBean cityLunBean) throws Exception {
                       retorModelCallBack1.Success(cityLunBean);
                    }
                });
    }

    @Override
    public void getCity2(HashMap<String, String> map, final RetorModelCallBack2 retorModelCallBack2) {
        RetorUtils.getStanice().create(UserService.class)
                .getCity2(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<CityZhanBean>() {
                    @Override
                    public void accept(CityZhanBean cityZhanBean) throws Exception {
                     retorModelCallBack2.Success(cityZhanBean);
                    }
                });
    }


    //modle
    public interface RetorModelCallBack{
        void Success(CityBean cityBean);
    }
    //modle
    public interface RetorModelCallBack1{
        void Success(CityLunBean cityLunBean);
    }
    //modle
    public interface RetorModelCallBack2{
        void Success(CityZhanBean cityZhanBean);
    }
}
