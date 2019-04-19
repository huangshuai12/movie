package com.bw.movie.mvp.model;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.CityZhanBean;
import com.bw.movie.entity.GuanZhuBean;
import com.bw.movie.entity.QuBean;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.GuanContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GuanModel implements GuanContract.GguanModel {


    @Override
    public void getGuan(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getGuan(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TuiBean>() {
                    @Override
                    public void accept(TuiBean tuiBean) throws Exception {
                        retorModelCallBack.Success(tuiBean);
                    }
                });
    }

    @Override
    public void getQu(HashMap<String, String> map, final RetorModelCallBack1 retorModelCallBack1) {
        RetorUtils.getStanice().create(UserService.class)
                .getQu(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TuiBean>() {
                    @Override
                    public void accept(TuiBean tuiBean) throws Exception {
                        retorModelCallBack1.Success(tuiBean);
                    }
                });
    }


    //modle
    public interface RetorModelCallBack{
        void Success(TuiBean tuiBean);
    }
    //modle
    public interface RetorModelCallBack1{
        void Success(TuiBean tuiBean);
    }
}
